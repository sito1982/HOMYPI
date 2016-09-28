package com.homypi.services;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.homypi.domotic.SerialRaspberryController;
import com.homypi.entity.Consumo;
import com.homypi.persistance.consumo.ConsumoRepository;
import com.homypi.utils.DateUtils;

@SpringBootApplication
@RestController
@ImportResource(locations = { "classpath*:spring-homy.xml" })
@EnableAutoConfiguration
public class HomyPiRestService {

	@Autowired
	ConsumoRepository consumoRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;

	@RequestMapping(path = "/consumo", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Consumo> getConsumo(@RequestParam(required = false, value = "desde") String desde,
			@RequestParam(required = false, value = "hasta") String hasta) {

		ArrayList<Consumo> listaConsumo = new ArrayList<Consumo>();

		if (!StringUtils.isEmpty(desde)) {
			if (!StringUtils.isEmpty(hasta)) {
				listaConsumo = consumoRepository.findConsumoByDateDesdeHasta(DateUtils.formatingDate(desde), DateUtils.formatingDate(hasta));

			} else {
				listaConsumo = consumoRepository.findConsumoByDateDesdeHasta(DateUtils.formatingDate(desde), new Date());
			}

		} else {
			
			Query query = new Query();
			query.limit(1);
			query.with(new Sort(Sort.Direction.DESC,"time"));
			mongoTemplate.find(query, Consumo.class);
			listaConsumo.add(mongoTemplate.find(query, Consumo.class).get(0));

		}

		return listaConsumo;
	}

	@RequestMapping("/temperatura")
	public String getTemperatura() {
		String temperatura = SerialRaspberryController.getTemperatura();
		return temperatura;

	}

	@RequestMapping("/calefaccion/encender")
	public String encenderCalefaccion() {
		String contestacion = SerialRaspberryController.encenderCalefaccion();
		return contestacion;

	}

	@RequestMapping("/calefaccion/apagar")
	public String apagarCalefaccion() {
		String contestacion = SerialRaspberryController.apagarCalefaccion();
		return contestacion;

	}

	public static void main(String[] args) {
		SpringApplication.run(HomyPiRestService.class, args);
	}

}
