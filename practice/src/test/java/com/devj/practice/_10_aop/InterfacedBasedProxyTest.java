package com.devj.practice._10_aop;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InterfacedBasedProxyTest {

	private final static String DO_SOMETHING="Do Target Logic in implemented instance";
	private final static String DO_NOTHING="Do Nothing";


	@Test
	@DisplayName("순수 자바 코드로 Proxy를 만들 수 있다.")
	void testProxy() {
		ProxyLogic proxiedLogic = new ProxyLogic(new TargetLogic());

		assertThat(proxiedLogic.doSomething(), is(DO_SOMETHING));
		assertThat(proxiedLogic.doNothing(), is(DO_NOTHING));
	}
}
