package org.ck.patterns.SpringAndMybatis;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @ClassName: MyBeanFactoryPostProcesser
 * @description
 * @Date 2020年05月12日 10:52:49
 */
public class MyBeanFactoryPostProcesser implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //通用的bean定义
        GenericBeanDefinition userDao=(GenericBeanDefinition) beanFactory.getBeanDefinition("userDao");
        userDao.setBeanClassName("userDaoChanged");
        userDao.setAbstract(false);

    }
}
