package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;
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

        ListSection achievement = new ListSection();
        List<String> achievementsList = achievement.getList();
        achievementsList.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", " +
                "\"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". " +
                "Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        achievementsList.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");

        ListSection qualifications = new ListSection();
        List<String> qualificationsList = qualifications.getList();
        qualificationsList.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualificationsList.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualificationsList.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle");

        OrganizationSection experience = new OrganizationSection();

        TimeInterval t2013_2020 = new TimeInterval(LocalDate.of(2013, 10, 1),
                LocalDate.of(2020, 2, 1));
        t2013_2020.setDescription("Автор проекта.Создание, организация и проведение Java онлайн проектов и стажировок.");
        Organization jop = new Organization("Java Online Projects", "http://javaops.ru/");
        Map<TimeInterval, Organization> experienceMap = experience.getOrganizationMap();
        experienceMap.put(t2013_2020, jop);

        OrganizationSection education = new OrganizationSection();
        TimeInterval tO32013_052013 = new TimeInterval(LocalDate.of(2013, 3, 1),
                LocalDate.of(2013, 5, 1));
        tO32013_052013.setDescription("\"Functional Programming Principles in Scala\" by Martin Odersky");
        Organization coursera = new Organization("Coursera", "https://www.coursera.org/course/progfun");
        Map<TimeInterval, Organization> educationMap = education.getOrganizationMap();
        educationMap.put(tO32013_052013, coursera);
        educationMap.put(t2013_2020, jop);

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
