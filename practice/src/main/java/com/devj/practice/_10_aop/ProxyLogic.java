package com.devj.practice._10_aop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProxyLogic implements Logic {

	Logic targetLogic;

	ProxyLogic(Logic targetLogic) {
		this.targetLogic = targetLogic;
	}

	@Override
	public String doSomething() {
		log.info("Proxy Instance :: doSomething");
		return targetLogic.doSomething();
	}

	@Override
	public String doNothing() {
		return targetLogic.doNothing();
	}
}