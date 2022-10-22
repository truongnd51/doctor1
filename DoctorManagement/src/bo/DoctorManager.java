/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Doctor;
import java.util.ArrayList;
import utils.Validation;

/**
 *
 * @author duytr
 */
public class DoctorManager {

    private ArrayList<Doctor> listDoctor;

    public DoctorManager() {
        listDoctor = new ArrayList<>();
    }

    public boolean addDoctor(Doctor d) throws Exception {
        if (isExist(d.getCode())) {
            throw new Exception("Doctor code existed!. Add fail");

        }
        return listDoctor.add(d);

    }

    private boolean isExist(String code) {
        return search(code) != -1;
    }


    public Doctor updateDoctor(String code, Doctor d) throws Exception {
        int i = search(code);
        if (i != -1) {
            return listDoctor.set(i, d);
        }
        throw new Exception("Doctor not found!");

    }

    public Doctor deleteDoctor(String code) throws Exception {
        int i = search(code);
        if (i != -1) {
            return listDoctor.remove(i);
        }
        throw new Exception("Code not exist!");

    }

    public ArrayList<Doctor> searchByCode(String code) {
        ArrayList<Doctor> ret = new ArrayList<>();
        for (Doctor d : listDoctor) {
            if (d.getCode().equalsIgnoreCase(code)) {
                ret.add(d);
            }
        }
        return ret;
    }

    private int search(String code) {
        for (int i = 0; i < listDoctor.size(); i++) {
            if (listDoctor.get(i).getCode().equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }

 
    public Doctor getDoctorByCode(String code) throws Exception {
        int i = search(code);
        if (i != -1) {
            return listDoctor.get(i);
        }
        throw new Exception("Code not found");
    }

}
