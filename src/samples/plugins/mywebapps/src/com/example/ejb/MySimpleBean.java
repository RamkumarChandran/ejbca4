package com.example.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.Local;

import org.apache.log4j.Logger;

import com.example.entity.MyCounterData;

import com.example.web.Counter;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;


import javax.annotation.PostConstruct;

@Stateless(name="mysimplebean")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Local(MySimpleBeanLocal.class)
public class MySimpleBean implements MySimpleBeanLocal {

    private final static Logger log = Logger.getLogger(MySimpleBean.class);
    
    private final static Integer FIXED_PK = 1;
    
    @PersistenceContext(unitName = "plugin")
    private EntityManager entityManager;


	@PostConstruct
	public void postConstruct()	{
		log.info("My Simple Bean is running!");
	}
	
	@Override
	public int updateCounter () {
		MyCounterData ac = getCurrent ();
		if (ac == null) {
			ac = new MyCounterData();
			ac.setPk(FIXED_PK);
			ac.setCounter(1);
			entityManager.persist (ac);
			return 1;
		}
		int i = ac.getCounter () + 1;
		ac.setCounter(i);
		entityManager.merge (ac);
		return i;
	}

	@Override
	public MyCounterData getCurrent() {
		return entityManager.find (MyCounterData.class, FIXED_PK);
	}

	@Override
	public void clearCounter() {
		MyCounterData ac = getCurrent ();
		if (ac != null) {
			entityManager.remove (ac);
		}
	}
}
