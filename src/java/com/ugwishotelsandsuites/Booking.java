/*
 * Copyright (c) 2018, Xyneex Technologies. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * You are not meant to edit or modify this source code unless you are
 * authorized to do so.
 *
 * Please contact Xyneex Technologies, #1 Orok Orok Street, Calabar, Nigeria.
 * or visit www.xyneex.com if you need additional information or have any
 * questions.
 */
package com.ugwishotelsandsuites;

import static com.ugwishotelsandsuites.Booking.BOOKINGS;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author KUFRE
 * @since Nov 14, 2023 2:35:43 PM
 */
@Entity
@Table(name = BOOKINGS)
public class Booking implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    private String room_id;
    private double total_amount;
    private String name;
    private String email;
    private String mobile_number;
    private String gender;
    private String date_in;
    private String date_out;
    private String room_count;
    private String adult_count;
    private String children_count;
    private Timestamp created_at;
    private Timestamp updated_at;

    public static final String MALE = "Male";
    public static final String FEMALE = "Female";

    public Booking()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getRoom_id()
    {
        return room_id;
    }

    public void setRoom_id(String room_id)
    {
        this.room_id = room_id;
    }

    public double getTotal_amount()
    {
        return total_amount;
    }

    public void setTotal_amount(double total_amount)
    {
        this.total_amount = total_amount;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getMobile_number()
    {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number)
    {
        this.mobile_number = mobile_number;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getDate_in()
    {
        return date_in;
    }

    public void setDate_in(String date_in)
    {
        this.date_in = date_in;
    }

    public String getDate_out()
    {
        return date_out;
    }

    public void setDate_out(String date_out)
    {
        this.date_out = date_out;
    }

    public String getRoom_count()
    {
        return room_count;
    }

    public void setRoom_count(String room_count)
    {
        this.room_count = room_count;
    }

    public String getAdult_count()
    {
        return adult_count;
    }

    public void setAdult_count(String adult_count)
    {
        this.adult_count = adult_count;
    }

    public String getChildren_count()
    {
        return children_count;
    }

    public void setChildren_count(String children_count)
    {
        this.children_count = children_count;
    }

    public Timestamp getCreated_at()
    {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at)
    {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at()
    {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at)
    {
        this.updated_at = updated_at;
    }

    public static final String BOOKINGS = "bookings";
    public static final String ID = "id";
    public static final String ROOM_ID = "room_id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String MOBILE_NUMBER = "mobile_number";
    public static final String GENDER = "gender";
    public static final String DATE_IN = "date_in";
    public static final String DATE_OUT = "date_out";
    public static final String ROOM_COUNT = "room_count";
    public static final String TOTAL_AMOUNT = "total_amount";
    public static final String ADULT_COUNT = "adult_count";
    public static final String CHILDREN_COUNT = "children_count";
    public static final String CREATED_AT = "created_at";
    public static final String UPDATED_AT = "updated_at";
}
