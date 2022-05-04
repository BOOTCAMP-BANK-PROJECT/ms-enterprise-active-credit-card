package com.bootcamp.enterprise.active.creditcard.util;

import java.util.Currency;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {

    public static boolean isValidCurrency(String code) {
        try {
            Currency c = Currency.getInstance(code);
            if (c != null) return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static void log(Class context_class, Level level, String message, Object[] params) {
        /**
         * ERROR – something terribly wrong had happened, that must be investigated immediately. No system can tolerate items logged on this level. Example: NPE, database unavailable, mission critical use case cannot be continued.
         *
         * WARN – the process might be continued, but take extra caution. Actually I always wanted to have two levels here: one for obvious problems where work-around exists (for example: “Current data unavailable, using cached values”) and second (name it: ATTENTION) for potential problems and suggestions. Example: “Application running in development mode” or “Administration console is not secured with a password”. The application can tolerate warning messages, but they should always be justified and examined.
         *
         * INFO – Important business process has finished. In ideal world, administrator or advanced user should be able to understand INFO messages and quickly find out what the application is doing. For example if an application is all about booking airplane tickets, there should be only one INFO statement per each ticket saying “[Who] booked ticket from [Where] to [Where]“. Other definition of INFO message: each action that changes the state of the application significantly (database update, external system request).
         *
         * DEBUG – Developers stuff. I will discuss later what sort of information deserves to be logged.
         *
         * TRACE – Very detailed information, intended only for development. You might keep trace messages for a short period of time after deployment on production environment, but treat these log statements as temporary, that should or might be turned-off eventually. The distinction between DEBUG and TRACE is the most difficult, but if you put logging statement and remove it after the feature has been developed and tested, it should probably be on TRACE level.
         */
        Logger logger = Logger.getLogger(String.valueOf(context_class));
        logger.log(level, message, params);
    }

    public static void log(Class context_class, Level level, String message) {
        log(context_class, level, message, null);
    }
}
