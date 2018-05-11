package com.springboot.learning.service;

import java.security.GeneralSecurityException;

/**
 * Created by fx on 2018/5/11.
 */
public interface MailService {


    String sendSimpleMail(String to, String subject, String content) throws GeneralSecurityException;
}
