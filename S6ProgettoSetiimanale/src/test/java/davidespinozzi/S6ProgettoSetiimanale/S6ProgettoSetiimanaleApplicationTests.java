package davidespinozzi.S6ProgettoSetiimanale;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import davidespinozzi.S6ProgettoSetiimanale.factory.SondaFactory;
import davidespinozzi.S6ProgettoSetiimanale.observer.CentroControllo;
import davidespinozzi.S6ProgettoSetiimanale.observer.SondaObservable;
import davidespinozzi.S6ProgettoSetiimanale.proxy.SondaProxy;

@SpringBootTest
class S6ProgettoSetiimanaleApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testAlarmNotification() {
		CentroControllo centroControllo = new CentroControllo("http://host");
		SondaObservable sonda = SondaFactory.createSonda(1, 41.0, 12.0);
		SondaObservable sonda1 = SondaFactory.createSonda(2, 41.0, 12.0);
		sonda.addObserver(centroControllo);
		sonda1.addObserver(centroControllo);
		sonda1.setSmokeLevel(4);
		sonda.setSmokeLevel(6);
	}

	@Test
	public void testProxy() {
		SondaProxy proxy = new SondaProxy("http://host");

		proxy.sendAlarm(2, 42.0, 13.0, 4);
	}

}
