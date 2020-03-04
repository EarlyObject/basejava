package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.*;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ru.javawebinar.basejava.util.DateUtil.of;

public class ResumeTestData {
    public static Resume R1;
    public static Resume R2;
    public static Resume R3;
    public static Resume R4;

    static {
        R1 = new Resume("uuid1", "Григорий Кислин");
        R2 = new Resume("uuid2", "Frank Lampard");
        R3 = new Resume("uuid3", "Антон Чехов");
        R4 = new Resume("uuid4", "Петр Чех");
    }


    public static void main(String[] args) {

        Map<ContactType, String> contacts = R1.getContacts();
        Map<SectionType, Section> sections = R1.getSections();

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
        Organization.Position tJop = new Organization.Position(of(2013, Month.OCTOBER),
                of(2020, Month.FEBRUARY), "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок.");
        List<Organization.Position> jopTI = new ArrayList<>();
        jopTI.add(tJop);
        Organization jop = new Organization("Java Online Projects", "http://javaops.ru/", jopTI);

        Organization.Position tWrike = new Organization.Position(of(2014, Month.OCTOBER), of(2016, Month.JANUARY), "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        List<Organization.Position> wrikeTI = new ArrayList<>();
        wrikeTI.add(tWrike);
        Organization wrike = new Organization("Wrike", "https://www.wrike.com/", wrikeTI);

        Organization.Position tRit = new Organization.Position(of(2012, Month.APRIL), of(2014, Month.OCTOBER), "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, " +
                "ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. " +
                "Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), " +
                "сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. " +
                "Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, " +
                "Unix shell remote scripting via ssh tunnels, PL/Python");
        List<Organization.Position> ritTI = new ArrayList<>();
        ritTI.add(tRit);
        Organization rit = new Organization("RIT Center", ritTI);

        Organization.Position tLuxoft = new Organization.Position(of(2010, Month.JANUARY), of(2012, Month.APRIL), "Ведущий программист", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). " +
                "Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов " +
                "в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.");
        List<Organization.Position> luxoftTI = new ArrayList<>();
        luxoftTI.add(tLuxoft);
        Organization luxoft = new Organization("Luxoft (Deutsche Bank)", "http://www.luxoft.ru/", luxoftTI);

        Organization.Position tYota = new Organization.Position(of(2008, Month.JUNE), of(2010, Month.DECEMBER), "Ведущий специалист", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                "Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)");
        List<Organization.Position> yotaTI = new ArrayList<>();
        yotaTI.add(tYota);
        Organization yota = new Organization("Yota", "https://www.yota.ru/", yotaTI);

        Organization.Position tEnkata = new Organization.Position(of(2007, Month.MARCH), of(2010, Month.DECEMBER), "Разработчик ПО", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).");
        List<Organization.Position> enkataTI = new ArrayList<>();
        enkataTI.add(tEnkata);
        Organization enkata = new Organization("Enkata", "http://enkata.com/", enkataTI);

        Organization.Position tSiemens = new Organization.Position(of(2005, Month.JANUARY), of(2007, Month.FEBRUARY), "Разработчик ПО", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).");
        List<Organization.Position> siemensTI = new ArrayList<>();
        siemensTI.add(tSiemens);
        Organization siemens = new Organization("Siemens AG", "https://www.siemens.com/ru/ru/home.html", siemensTI);

        Organization.Position tAlcatel = new Organization.Position(of(1997, Month.SEPTEMBER), of(2005, Month.JANUARY), "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        List<Organization.Position> alcatelTI = new ArrayList<>();
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
        Organization.Position tCoursera = new Organization.Position(of(2013, Month.MARCH),
                of(2013, Month.MAY), "\"Functional Programming Principles in Scala\" by Martin Odersky", "");
        List<Organization.Position> courseraTI = new ArrayList<>();
        courseraTI.add(tCoursera);
        Organization coursera = new Organization("Coursera", "https://www.coursera.org/course/progfun", courseraTI);

        Organization.Position teLuxoft = new Organization.Position(of(2011, Month.MARCH), of(2011, Month.APRIL), "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", "");
        List<Organization.Position> eluxoftTI = new ArrayList<>();
        eluxoftTI.add(teLuxoft);
        Organization eLuxoft = new Organization("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366", eluxoftTI);

        Organization.Position teSiemens = new Organization.Position(of(2005, Month.JANUARY), of(2005, Month.APRIL), "3 месяца обучения мобильным IN сетям (Берлин)", "");
        List<Organization.Position> eSiemensTI = new ArrayList<>();
        eSiemensTI.add(teSiemens);
        Organization eSiemens = new Organization("Siemens AG", "http://www.siemens.ru/", eSiemensTI);

        Organization.Position teAlcatel = new Organization.Position(of(1997, Month.SEPTEMBER), of(1998, Month.MARCH), "6 месяцев обучения цифровым телефонным сетям (Москва)", "");
        List<Organization.Position> eAlcatelTI = new ArrayList<>();
        eAlcatelTI.add(teAlcatel);
        Organization eAlcatel = new Organization("Alcatel", "http://www.alcatel.ru/", eAlcatelTI);

        Organization.Position tSpniu = new Organization.Position(of(1993, Month.SEPTEMBER), of(1996, Month.JULY), "Аспирантура (программист С, С++)", "");
        Organization.Position tSpniu2 = new Organization.Position(of(1987, Month.SEPTEMBER), of(1993, Month.JULY), "Инженер (программист Fortran, C)", "");
        List<Organization.Position> spniuTI = new ArrayList<>();
        spniuTI.add(tSpniu);
        spniuTI.add(tSpniu2);
        Organization SPNIU = new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                "http://www.ifmo.ru/",
                spniuTI);

        Organization.Position tZFTS = new Organization.Position(of(1984, Month.SEPTEMBER), of(1987, Month.JUNE), "Закончил с отличием", "");
        List<Organization.Position> zftsTI = new ArrayList<>();
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

        for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
        for (Map.Entry<SectionType, Section> entry : sections.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        Map<ContactType, String> contacts2 = R2.getContacts();
        Map<SectionType, Section> sections2 = R2.getSections();

        contacts2.put(ContactType.PHONE_NUMBER, "+7(777) 777-7777");
        contacts2.put(ContactType.SKYPE, "frank.lampard");
        contacts2.put(ContactType.EMAIL, "frank@gmail.com");
        contacts2.put(ContactType.LINKEDIN_PROFILE, "https://www.linkedin.com/in/flampard");
        contacts2.put(ContactType.GITHUB_PROFILE, "https://github.com/flampard");
        contacts2.put(ContactType.STACKOVERFLOW_PROFILE, "https://stackoverflow.com/users/777777");
        contacts2.put(ContactType.WEBPAGE, "http://lampard.com");

        TextSection objective2 = new TextSection("Тренер футбольной команды");
        TextSection personal2 = new TextSection("Аналитический склад ума, сильная логика, дисциплина, воля, характер. Лидер по рождению.");

        List<String> achievementsList2 = new ArrayList<>();
        ListSection achievement2 = new ListSection(achievementsList2);

        achievementsList2.add("Чемпионат Англии 2005. Лига Чемпионов. Кубок Англии много раз");
        achievementsList2.add("Многократно признавался игроком месяца, Лучшим игроком года");

        List<String> qualificationsList2 = new ArrayList<>();
        ListSection qualifications2 = new ListSection(qualificationsList2);

        qualificationsList2.add("Центральный полузащитник");
        qualificationsList2.add("Атакующий полузащитник");
        qualificationsList2.add("Диспетчер");

        List<Organization> experienceList2 = new ArrayList<>();
        OrganizationSection experience2 = new OrganizationSection(experienceList2);
        Organization.Position tChelsea = new Organization.Position(of(2000, Month.JANUARY),
                of(2012, Month.JUNE), "Член футбольной команды", "Игра в центре поля в связке с другими центраравами");
        List<Organization.Position> chelseaTI = new ArrayList<>();
        chelseaTI.add(tChelsea);
        Organization chelseaFC = new Organization("Chelsea Futboll club", "http://chelsea.com/", chelseaTI);

        Organization.Position tWestHam = new Organization.Position(of(1998, Month.JANUARY), of(1999, Month.DECEMBER), "Стажер в Академии ФК ВестХэм", "Участие в юношеских турнирах УЕФА");
        List<Organization.Position> westHamTI = new ArrayList<>();
        westHamTI.add(tWestHam);
        Organization westHam = new Organization("WestHam FC", "https://www.westham.com/", westHamTI);

        experienceList2.add(chelseaFC);
        experienceList2.add(westHam);

        List<Organization> educationList2 = new ArrayList<>();
        OrganizationSection education2 = new OrganizationSection(educationList2);

        Organization.Position tBrantford = new Organization.Position(of(1998, Month.JANUARY),
                of(1998, Month.AUGUST), "Школа ударов с двух ног", "");
        List<Organization.Position> brantfordTI = new ArrayList<>();
        brantfordTI.add(tBrantford);
        Organization brantford = new Organization("Brantford FC", "https://www.brantford.com", brantfordTI);

        Organization.Position tNorwich = new Organization.Position(of(1995, Month.FEBRUARY), of(1997, Month.DECEMBER), "Основы юношеского футбола", "");
        List<Organization.Position> norwichTI = new ArrayList<>();
        norwichTI.add(tNorwich);
        Organization norwich = new Organization("Norwich FC", "http://www.norwich.com", norwichTI);

        educationList2.add(brantford);
        educationList2.add(norwich);

        sections2.put(SectionType.OBJECTIVE, objective2);
        sections2.put(SectionType.PERSONAL, personal2);
        sections2.put(SectionType.ACHIEVEMENT, achievement2);
        sections2.put(SectionType.QUALIFICATIONS, qualifications2);
        sections2.put(SectionType.EXPERIENCE, experience2);
        sections2.put(SectionType.EDUCATION, education2);

        System.out.println(R2.getFullName());
        System.out.println();

        for (Map.Entry<ContactType, String> entry : contacts2.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
        for (Map.Entry<SectionType, Section> entry : sections2.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }


        Map<ContactType, String> contacts3 = R3.getContacts();
        Map<SectionType, Section> sections3 = R3.getSections();

        contacts3.put(ContactType.PHONE_NUMBER, "+7(999) 999-9999");
        contacts3.put(ContactType.SKYPE, "anton.chekhov");
        contacts3.put(ContactType.EMAIL, "achekhov@gmail.com");
        contacts3.put(ContactType.LINKEDIN_PROFILE, "https://www.linkedin.com/in/achekhov");
        contacts3.put(ContactType.GITHUB_PROFILE, "https://github.com/achekhov");
        contacts3.put(ContactType.STACKOVERFLOW_PROFILE, "https://stackoverflow.com/users/99999");
        contacts3.put(ContactType.WEBPAGE, "http://chekhov.com");

        TextSection objective3 = new TextSection("Сценарист");
        TextSection personal3 = new TextSection("Альтруизм, нестандартное мышление, ироничность, краткость, креативность.");

        List<String> achievementsList3 = new ArrayList<>();
        ListSection achievement3 = new ListSection(achievementsList3);

        achievementsList3.add("Руководитель проекта — три школы в Талеже, Новоселках и Мелихове");
        achievementsList3.add("Признанный литератор");

        List<String> qualificationsList3 = new ArrayList<>();
        ListSection qualifications3 = new ListSection(qualificationsList3);

        qualificationsList3.add("Журналист-фрилансер");
        qualificationsList3.add("Репетитор по русскому языку");
        qualificationsList3.add("Врач-практикант");

        List<Organization> experienceList3 = new ArrayList<>();
        OrganizationSection experience3 = new OrganizationSection(experienceList3);
        Organization.Position tLiterator = new Organization.Position(of(1896, Month.JANUARY),
                of(1898, Month.DECEMBER), "Литератор — Мелихово", "Творческая деятельность на природе, работа над произведениями «Палата №6»," +
                " «Человек в футляре», «Ионыч», «Чайка» и «Дядя Ваня» и др.");
        List<Organization.Position> literatorTI = new ArrayList<>();
        literatorTI.add(tLiterator);
        Organization literator = new Organization("Мелихово", "http://melikhovo.com/", literatorTI);

        Organization.Position tGazeta = new Organization.Position(of(1886, Month.JANUARY), of(1898, Month.DECEMBER), "Фельетонист — Петербург, газета «Новое время».", "Удаленная работа, написание «субботников».");
        List<Organization.Position> gazetaTI = new ArrayList<>();
        gazetaTI.add(tGazeta);
        Organization gazeta = new Organization("Новое время", "https://www.new-time.ru/", gazetaTI);

        experienceList3.add(literator);
        experienceList3.add(gazeta);

        List<Organization> educationList3 = new ArrayList<>();
        OrganizationSection education3 = new OrganizationSection(educationList3);

        Organization.Position tMGU = new Organization.Position(of(1879, Month.SEPTEMBER),
                of(1884, Month.JUNE), "Московский университет (МГУ), медицинский факультет.", "");
        List<Organization.Position> mguTI = new ArrayList<>();
        mguTI.add(tMGU);
        Organization mgu = new Organization("Московский университет (МГУ)", "https://www.mgu.ru", mguTI);

        Organization.Position tTaganrog = new Organization.Position(of(1867, Month.SEPTEMBER), of(1879, Month.MAY), "Таганрогская мужская гимназия. Школьный курс", "");
        List<Organization.Position> taganrogTI = new ArrayList<>();
        taganrogTI.add(tTaganrog);
        Organization taganrog = new Organization("Таганрогская мужская классическая гимназия.", "http://www.tgnr.ru", taganrogTI);

        educationList3.add(mgu);
        educationList3.add(taganrog);

        sections3.put(SectionType.OBJECTIVE, objective3);
        sections3.put(SectionType.PERSONAL, personal3);
        sections3.put(SectionType.ACHIEVEMENT, achievement3);
        sections3.put(SectionType.QUALIFICATIONS, qualifications3);
        sections3.put(SectionType.EXPERIENCE, experience3);
        sections3.put(SectionType.EDUCATION, education3);

        System.out.println(R3.getFullName());
        System.out.println();

        for (Map.Entry<ContactType, String> entry : contacts3.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
        for (Map.Entry<SectionType, Section> entry : sections3.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }


}
