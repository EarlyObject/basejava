package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainResume {
    public static void main(String[] args) {
        Resume testResume = new Resume("Григорий Кислин");

        Map<ContactType, String> contacts = testResume.getContacts();
        Map<SectionType, Section> sections = testResume.getSections();

        contacts.put(ContactType.PHONE_NUMBER, "+7(921) 855-0482");
        contacts.put(ContactType.SKYPE, "grigory.kislin");
        contacts.put(ContactType.EMAIL, "gkislin@yandex.ru");
        contacts.put(ContactType.LINKEDIN_PROFILE, "https://www.linkedin.com/in/gkislin");
        contacts.put(ContactType.GITHUB_PROFILE, "https://github.com/gkislin");
        contacts.put(ContactType.STACKOVERFLOW_PROFILE, "https://stackoverflow.com/users/548473");
        contacts.put(ContactType.WEBPAGE, "http://gkislin.ru/");

        TextSection objective = new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        TextSection personal = new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");

        List<String> achievementsList = new ArrayList<>();
        ListSection achievement = new ListSection(achievementsList);

        achievementsList.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", " +
                "\"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". " +
                "Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        achievementsList.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievementsList.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. " +
                "Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. " +
                "Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        achievementsList.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, " +
                "Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievementsList.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). " +
                "Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. " +
                "Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        achievementsList.add("Реализация протоколов по приему платежей всех основных платежных системы России " +
                "(Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

        List<String> qualificationsList = new ArrayList<>();
        ListSection qualifications = new ListSection(qualificationsList);

        qualificationsList.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualificationsList.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualificationsList.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle");
        qualificationsList.add("MySQL, SQLite, MS SQL, HSQLDB");
        qualificationsList.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,");
        qualificationsList.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,");
        qualificationsList.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), " +
                "JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        qualificationsList.add("Python: Django.");
        qualificationsList.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        qualificationsList.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        qualificationsList.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, " +
                "JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        qualificationsList.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix,");
        qualificationsList.add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        qualificationsList.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования");
        qualificationsList.add("Родной русский, английский \"upper intermediate\"");

        List<Organization> experienceList = new ArrayList<>();
        OrganizationSection experience = new OrganizationSection(experienceList);
        TimeInterval tJop = new TimeInterval(LocalDate.of(2013, 10, 1),
                LocalDate.of(2020, 2, 1));
        tJop.setPosition("Автор проекта.");
        tJop.setDescription("Создание, организация и проведение Java онлайн проектов и стажировок.");
        List<TimeInterval> jopTI = new ArrayList<>();
        jopTI.add(tJop);
        Organization jop = new Organization("Java Online Projects", "http://javaops.ru/", jopTI);

        TimeInterval tWrike = new TimeInterval(LocalDate.of(2014, 10, 1), LocalDate.of(2016, 1, 1));
        tWrike.setPosition("Старший разработчик (backend)");
        tWrike.setDescription("Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        List<TimeInterval> wrikeTI = new ArrayList<>();
        wrikeTI.add(tWrike);
        Organization wrike = new Organization("Wrike", "https://www.wrike.com/", wrikeTI);

        TimeInterval tRit = new TimeInterval(LocalDate.of(2012, 4, 1), LocalDate.of(2014, 10, 1));
        tRit.setPosition("Java архитектор");
        tRit.setDescription("Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, " +
                "ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. " +
                "Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), " +
                "сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. " +
                "Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, " +
                "Unix shell remote scripting via ssh tunnels, PL/Python");
        List<TimeInterval> ritTI = new ArrayList<>();
        ritTI.add(tRit);
        Organization rit = new Organization("RIT Center", ritTI);

        TimeInterval tLuxoft = new TimeInterval(LocalDate.of(2010, 1, 1), LocalDate.of(2012, 4, 1));
        tLuxoft.setPosition("Ведущий программист");
        tLuxoft.setDescription("Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). " +
                "Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов " +
                "в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.");
        List<TimeInterval> luxoftTI = new ArrayList<>();
        luxoftTI.add(tLuxoft);
        Organization luxoft = new Organization("Luxoft (Deutsche Bank)", "http://www.luxoft.ru/", luxoftTI);

        TimeInterval tYota = new TimeInterval(LocalDate.of(2008, 6, 1), LocalDate.of(2010, 12, 1));
        tYota.setPosition("Ведущий специалист");
        tYota.setDescription("Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                "Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)");
        List<TimeInterval> yotaTI = new ArrayList<>();
        yotaTI.add(tYota);
        Organization yota = new Organization("Yota", "https://www.yota.ru/", yotaTI);

        TimeInterval tEnkata = new TimeInterval(LocalDate.of(2007, 3, 1), LocalDate.of(2010, 12, 1));
        tEnkata.setPosition("Разработчик ПО");
        tEnkata.setDescription("Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).");
        List<TimeInterval> enkataTI = new ArrayList<>();
        enkataTI.add(tEnkata);
        Organization enkata = new Organization("Enkata", "http://enkata.com/", enkataTI);

        TimeInterval tSiemens = new TimeInterval(LocalDate.of(2005, 1, 1), LocalDate.of(2007, 2, 1));
        tSiemens.setPosition("Разработчик ПО");
        tSiemens.setDescription("Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).");
        List<TimeInterval> siemensTI = new ArrayList<>();
        siemensTI.add(tSiemens);
        Organization siemens = new Organization("Siemens AG", "https://www.siemens.com/ru/ru/home.html", siemensTI);

        TimeInterval tAlcatel = new TimeInterval(LocalDate.of(1997, 9, 1), LocalDate.of(2005, 1, 1));
        tAlcatel.setPosition("Инженер по аппаратному и программному тестированию");
        tAlcatel.setDescription("Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        List<TimeInterval> alcatelTI = new ArrayList<>();
        alcatelTI.add(tAlcatel);
        Organization alcatel = new Organization("Alcatel", "http://www.alcatel.ru/", alcatelTI);

        experienceList.add(jop);
        experienceList.add(wrike);
        experienceList.add(rit);
        experienceList.add(luxoft);
        experienceList.add(yota);
        experienceList.add(enkata);
        experienceList.add(siemens);
        experienceList.add(alcatel);

        List<Organization> educationList = new ArrayList<>();
        OrganizationSection education = new OrganizationSection(educationList);
        TimeInterval tCoursera = new TimeInterval(LocalDate.of(2013, 3, 1),
                LocalDate.of(2013, 5, 1));
        tCoursera.setPosition("\"Functional Programming Principles in Scala\" by Martin Odersky");
        List<TimeInterval> courseraTI = new ArrayList<>();
        courseraTI.add(tCoursera);
        Organization coursera = new Organization("Coursera", "https://www.coursera.org/course/progfun", courseraTI);

        TimeInterval teLuxoft = new TimeInterval(LocalDate.of(2011, 3, 1), LocalDate.of(2011, 4, 1));
        teLuxoft.setPosition("Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"");
        List<TimeInterval> eluxoftTI = new ArrayList<>();
        eluxoftTI.add(teLuxoft);
        Organization eLuxoft = new Organization("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366", eluxoftTI);

        TimeInterval teSiemens = new TimeInterval(LocalDate.of(2005, 1, 1), LocalDate.of(2005, 4, 1));
        teLuxoft.setPosition("3 месяца обучения мобильным IN сетям (Берлин)");
        List<TimeInterval> eSiemensTI = new ArrayList<>();
        eSiemensTI.add(teSiemens);
        Organization eSiemens = new Organization("Siemens AG", "http://www.siemens.ru/", eSiemensTI);

        TimeInterval teAlcatel = new TimeInterval(LocalDate.of(1997, 9, 1), LocalDate.of(1998, 3, 1));
        teAlcatel.setPosition("6 месяцев обучения цифровым телефонным сетям (Москва)");
        List<TimeInterval> eAlcatelTI = new ArrayList<>();
        eAlcatelTI.add(teAlcatel);
        Organization eAlcatel = new Organization("Alcatel", "http://www.alcatel.ru/", eAlcatelTI);

        TimeInterval tSpniu = new TimeInterval(LocalDate.of(1993, 9, 1), LocalDate.of(1996, 7, 1));
        tSpniu.setPosition("Аспирантура (программист С, С++)");
        TimeInterval tSpniu2 = new TimeInterval(LocalDate.of(1987, 9, 1), LocalDate.of(1993, 7, 1));
        tSpniu2.setPosition("Инженер (программист Fortran, C)");
        List<TimeInterval> spniuTI = new ArrayList<>();
        spniuTI.add(tSpniu);
        spniuTI.add(tSpniu2);
        Organization SPNIU = new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                "http://www.ifmo.ru/",
                spniuTI);

        TimeInterval tZFTS = new TimeInterval(LocalDate.of(1984, 9, 1), LocalDate.of(1987, 6, 1));
        tZFTS.setPosition("Закончил с отличием");
        List<TimeInterval> zftsTI = new ArrayList<>();
        zftsTI.add(tZFTS);
        Organization zfts = new Organization("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/", zftsTI);

        educationList.add(coursera);
        educationList.add(eLuxoft);
        educationList.add(eSiemens);
        educationList.add(eAlcatel);
        educationList.add(SPNIU);
        educationList.add(zfts);

        sections.put(SectionType.OBJECTIVE, objective);
        sections.put(SectionType.PERSONAL, personal);
        sections.put(SectionType.ACHIEVEMENT, achievement);
        sections.put(SectionType.QUALIFICATIONS, qualifications);
        sections.put(SectionType.EXPERIENCE, experience);
        sections.put(SectionType.EDUCATION, education);

        System.out.println(testResume.getFullName());
        System.out.println();

        for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
        for (Map.Entry<SectionType, Section> entry : sections.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
