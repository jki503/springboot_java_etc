package com.devj.practice._10_aop;

public class TargetLogic implements Logic{

	@Override
	public String doSomething() {
		return "Do Target Logic in implemented instance";
	}

	@Override
	public String doNothing() {
		return "Do Nothing";
	}
}
