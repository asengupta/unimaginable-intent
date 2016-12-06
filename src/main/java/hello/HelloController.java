package hello;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.core.ClassEmitter;
import org.springframework.cglib.core.NamingPolicy;
import org.springframework.cglib.core.Predicate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.ResolvableType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController implements ApplicationContextAware {
    private RandomStuff<String> s;
    private final ConfigurableListableBeanFactory beanFactory;
    private ApplicationContext applicationContext;

    @Autowired
    public HelloController(RandomStuff<String> s, ConfigurableListableBeanFactory beanFactory) {
        this.s = s;
        this.beanFactory = beanFactory;
    }

    @RequestMapping("/lol")
    public String index() throws NoSuchFieldException {
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("lol", RandomStuff.class);

        beanGenerator.setNamingPolicy(new NamingPolicy() {
            @Override
            public String getClassName(final String prefix,
                                       final String source, final Object key, final Predicate names) {
                return "LOLCLASS";
            }
        });
        Class aClass = (Class) beanGenerator.createClass();
        ResolvableType resolvableType = ResolvableType.forClassWithGenerics(RandomStuff.class, String.class);
//        String[] beanNamesForType = applicationContext.getBeanNamesForType(resolvableType);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(RandomStuff.class);
//        ResolvableType ofString = ResolvableType.forClass(applicationContext.getAutowireCapableBeanFactory().getType("ofString"));
//        ResolvableType ofToken = ResolvableType.forClass(applicationContext.getAutowireCapableBeanFactory().getType("ofTokenRule"));

        Field lolField = aClass.getDeclaredField("lol");
        List<String> namesAsList = Arrays.asList(beanNamesForType);
        ArrayList<RandomStuff> candidates = new ArrayList<>();
        Object candidate = applicationContext.getAutowireCapableBeanFactory().resolveDependency(new DependencyDescriptor(lolField, true, true), null);
        ResolvableType blah = null;
        Type result = null;
        String[] beanNames = beanFactory.getBeanNamesForType(RandomStuff.class);
        for (String name: beanNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            Class<?> factoryClass = beanFactory.getBean(beanDefinition.getFactoryBeanName()).getClass();
            for (Method method: factoryClass.getDeclaredMethods()) {
                if (method.getName().equals(beanDefinition.getFactoryMethodName())) {
                    blah = ResolvableType.forMethodReturnType(method);
                    result = method.getGenericReturnType();
                }
            }
        }
//        boolean assignableFrom1 = ofString.isAssignableFrom(resolvableType);
//        boolean assignableFrom2 = ofToken.isAssignableFrom(resolvableType);
        System.out.println(s);
        return "Greetings from Spring Boot!";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}