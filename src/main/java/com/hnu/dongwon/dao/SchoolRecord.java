package com.hnu.dongwon.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolRecord {
    private String category;
    private String employeeId;
    private String schoolId;
    private String serviceNum;
    private String selfServiceNum;
    private String college;
    private String major;
    private String process; // 학습과정
    private String secretNum;
    private int gradeSet; // 학년제
    private int semesterSet; // 학기제
    private int grade;
    private int completeGrade; // 이수학기
    private boolean isOverGrade; // 학기초과
    private String name;
    private String status; // 학적상태
    private String statusReason;
    private String address; // 거주지 주소
    private String contact; // 연락처
    private String phoneNum;
    private String changeDate; // 변동일
    private boolean isOut; // 전출여부
    private String nameBirth; // 성명생일
    private String branchOfArmy; // 병종
    private boolean isTransfer; // 전출대상
    private boolean isCheck; // 학적초과검토대상
    private String email;
    private String nameServiceNum; // 성명군번
    private boolean isSearch; // 검색비대상
    private boolean isMove; // 전입대상
    private String note; // 참고사항
    private boolean requestMove; // 전입요청
    private String birth; // 생년월일
    private String dischargeDate; // 전역일
    private int year; // 년차
    private boolean requestOut; // 전출요청
    private String photo; // 사진 (클래스 모름)
    private int serialNum; // 연번
    private String civilSo; // 민소
    private String civilPosition; // 민직책
    private boolean minpyeun; // 민편
    private boolean isAgreeMail; // 메일수신동의
    private String bank; // 은행
    private String account; // 계좌
    private boolean adminCheckName; // 관리자확인 성명
    private boolean adminCheckPhone;
    private boolean adminCheckCall;
    private boolean adminCheckMail;
    private String requestMoveDate; // 전입요청일자
    private String checkMoveDate; // 전입확인일자
    private String requestOutDate; // 전출요청일자
    private String checkOutDate; // 전출확인일자
    private int age;
    private int maxAge;
    private String rank;
    private String enlistDate; // 입영일
    private String standardDepart; // 표준학과
    private String outReason; // 전출사유
    private String isOneSemester; // 한학기이수여부
    private int lastSemester; // 직전이수학기

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(String serviceNum) {
        this.serviceNum = serviceNum;
    }

    public String getSelfServiceNum() {
        return selfServiceNum;
    }

    public void setSelfServiceNum(String selfServiceNum) {
        this.selfServiceNum = selfServiceNum;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getSecretNum() {
        return secretNum;
    }

    public void setSecretNum(String secretNum) {
        this.secretNum = secretNum;
    }

    public int getGradeSet() {
        return gradeSet;
    }

    public void setGradeSet(int gradeSet) {
        this.gradeSet = gradeSet;
    }

    public int getSemesterSet() {
        return semesterSet;
    }

    public void setSemesterSet(int semesterSet) {
        this.semesterSet = semesterSet;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getCompleteGrade() {
        return completeGrade;
    }

    public void setCompleteGrade(int completeGrade) {
        this.completeGrade = completeGrade;
    }

    public boolean isOverGrade() {
        return isOverGrade;
    }

    public void setOverGrade(boolean overGrade) {
        isOverGrade = overGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }

    public boolean isOut() {
        return isOut;
    }

    public void setOut(boolean out) {
        isOut = out;
    }

    public String getNameBirth() {
        return nameBirth;
    }

    public void setNameBirth(String nameBirth) {
        this.nameBirth = nameBirth;
    }

    public String getBranchOfArmy() {
        return branchOfArmy;
    }

    public void setBranchOfArmy(String branchOfArmy) {
        this.branchOfArmy = branchOfArmy;
    }

    public boolean isTransfer() {
        return isTransfer;
    }

    public void setTransfer(boolean transfer) {
        isTransfer = transfer;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameServiceNum() {
        return nameServiceNum;
    }

    public void setNameServiceNum(String nameServiceNum) {
        this.nameServiceNum = nameServiceNum;
    }

    public boolean isSearch() {
        return isSearch;
    }

    public void setSearch(boolean search) {
        isSearch = search;
    }

    public boolean isMove() {
        return isMove;
    }

    public void setMove(boolean move) {
        isMove = move;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isRequestMove() {
        return requestMove;
    }

    public void setRequestMove(boolean requestMove) {
        this.requestMove = requestMove;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isRequestOut() {
        return requestOut;
    }

    public void setRequestOut(boolean requestOut) {
        this.requestOut = requestOut;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public String getCivilSo() {
        return civilSo;
    }

    public void setCivilSo(String civilSo) {
        this.civilSo = civilSo;
    }

    public String getCivilPosition() {
        return civilPosition;
    }

    public void setCivilPosition(String civilPosition) {
        this.civilPosition = civilPosition;
    }

    public boolean isMinpyeun() {
        return minpyeun;
    }

    public void setMinpyeun(boolean minpyeun) {
        this.minpyeun = minpyeun;
    }

    public boolean isAgreeMail() {
        return isAgreeMail;
    }

    public void setAgreeMail(boolean agreeMail) {
        isAgreeMail = agreeMail;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public boolean isAdminCheckName() {
        return adminCheckName;
    }

    public void setAdminCheckName(boolean adminCheckName) {
        this.adminCheckName = adminCheckName;
    }

    public boolean isAdminCheckPhone() {
        return adminCheckPhone;
    }

    public void setAdminCheckPhone(boolean adminCheckPhone) {
        this.adminCheckPhone = adminCheckPhone;
    }

    public boolean isAdminCheckCall() {
        return adminCheckCall;
    }

    public void setAdminCheckCall(boolean adminCheckCall) {
        this.adminCheckCall = adminCheckCall;
    }

    public boolean isAdminCheckMail() {
        return adminCheckMail;
    }

    public void setAdminCheckMail(boolean adminCheckMail) {
        this.adminCheckMail = adminCheckMail;
    }

    public String getRequestMoveDate() {
        return requestMoveDate;
    }

    public void setRequestMoveDate(String requestMoveDate) {
        this.requestMoveDate = requestMoveDate;
    }

    public String getCheckMoveDate() {
        return checkMoveDate;
    }

    public void setCheckMoveDate(String checkMoveDate) {
        this.checkMoveDate = checkMoveDate;
    }

    public String getRequestOutDate() {
        return requestOutDate;
    }

    public void setRequestOutDate(String requestOutDate) {
        this.requestOutDate = requestOutDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getEnlistDate() {
        return enlistDate;
    }

    public void setEnlistDate(String enlistDate) {
        this.enlistDate = enlistDate;
    }

    public String getStandardDepart() {
        return standardDepart;
    }

    public void setStandardDepart(String standardDepart) {
        this.standardDepart = standardDepart;
    }

    public String getOutReason() {
        return outReason;
    }

    public void setOutReason(String outReason) {
        this.outReason = outReason;
    }

    public String getIsOneSemester() {
        return isOneSemester;
    }

    public void setIsOneSemester(String isOneSemester) {
        this.isOneSemester = isOneSemester;
    }

    public int getLastSemester() {
        return lastSemester;
    }

    public void setLastSemester(int lastSemester) {
        this.lastSemester = lastSemester;
    }
}
