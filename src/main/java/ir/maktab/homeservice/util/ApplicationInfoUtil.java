package ir.maktab.homeservice.util;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ApplicationInfoUtil {

    public static final String TITLE = "HomeServiceProvider";
    public static final String DESCRIPTION = "This system provides various home services";
    public static final String VERSION = "1.0";

    private static final String CONTACT_NAME = "Iman Hosseinzadeh";
    private static final String CONTACT_EMAIL = "Imhosseinzadeh@gmail.com";
    private static final String CONTACT_URL = "ImanHosseinzadeh.com";

    public static final Contact CONTACT = new Contact().name(CONTACT_NAME).email(CONTACT_EMAIL).url(CONTACT_URL);

    private static final String LICENSE_NAME = "License 2022";
    private static final String LICENSE_URL = "License Url";

    public static final License LICENSE = new License().name(LICENSE_NAME).url(LICENSE_URL);
}

