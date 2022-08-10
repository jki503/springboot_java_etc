package com.devj.practice._10_aop;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ReflectionPersonTest {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Test
	@DisplayName("동적으로 ReflectionPerson 인스턴스 만들기")
	void getInstanceDynamically() {
		try {
			Class<?> clazz = ReflectionPerson.class;
			assertThat(clazz).isEqualTo(ReflectionPerson.class);

			Constructor[] cons = clazz.getDeclaredConstructors();
			log.info("constructors : {}" , Arrays.toString(cons));

			Constructor<?> con = clazz.getDeclaredConstructor(String.class, Integer.class);
			log.info("declaredcon : {}", con);

			Object obj = con.newInstance();
			assertThat(obj).isInstanceOf(ReflectionPerson.class);

		} catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("동적으로 method 실행하기")
	void invokeMethodDynamically() {
		try {
			final String address = "Songpa";

			Class<?> clazz = ReflectionPerson.class;
			Object obj = clazz.getDeclaredConstructor().newInstance();

			Method[] methods = clazz.getMethods();
			Arrays.stream(methods).forEach(
				m-> log.info("methodName : {}", m.getName())
			);

			Method setMethod = Arrays.stream(methods)
				.filter(m-> m.getName().startsWith("set"))
				.findAny().get();

			setMethod.invoke(obj, address);   //invoke 시에 인스턴스가 필요하다.

			Method getAddressMethod = Arrays.stream(methods)
				.filter(m->m.getName().equals("getAddress"))
				.findAny().get();

			String invokedAddress = String.valueOf(getAddressMethod.invoke(obj));


		} catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}