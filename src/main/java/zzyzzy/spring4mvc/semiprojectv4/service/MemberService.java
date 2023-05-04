package zzyzzy.spring4mvc.semiprojectv4.service;

import zzyzzy.spring4mvc.semiprojectv4.model.Member;

import javax.servlet.http.HttpSession;

public interface MemberService {
    boolean checkLogin(Member m, HttpSession sess);
}
