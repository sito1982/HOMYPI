import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homypi.entity.Consumo;
import com.homypi.persistance.consumo.ConsumoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@EnableMongoRepositories({"com.homypi.persistance.*"})
@ContextConfiguration(locations = { "classpath*:spring-homy.xml"})
public class testingMongoDB {
	
	@Autowired
	ConsumoRepository consumoRepository;

	@Test	
	public void testingSave() {

		long consumo = 1150;
		Consumo consumoEntity = new Consumo();
		consumoEntity.setConsumo(consumo);
		consumoEntity.setTime(new Date());
		consumoRepository.save(consumoEntity);

	}

}
