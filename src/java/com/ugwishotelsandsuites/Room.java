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

import static com.ugwishotelsandsuites.Room.ROOMS;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author KUFRE
 * @since Nov 12, 2023 10:13:38 PM
 */
@Entity
@Table(name = ROOMS)
public class Room implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    private String title;
    private String description;
    private String type;
    private Double cost;
    private int bedCapacity;
    private String meal;
    private Boolean aircondition;
    private String image;
    private Timestamp createdAt;
    private Timestamp updateAt;

    public Room()
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

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Double getCost()
    {
        return cost;
    }

    public void setCost(Double cost)
    {
        this.cost = cost;
    }

    public int getBedCapacity()
    {
        return bedCapacity;
    }

    public void setBedCapacity(int bedCapacity)
    {
        this.bedCapacity = bedCapacity;
    }

    public String getMeal()
    {
        return meal;
    }

    public void setMeal(String meal)
    {
        this.meal = meal;
    }

    public Boolean getAircondition()
    {
        return aircondition;
    }

    public void setAircondition(Boolean aircondition)
    {
        this.aircondition = aircondition;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public Timestamp getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt)
    {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdateAt()
    {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt)
    {
        this.updateAt = updateAt;
    }
    public static final String ROOMS = "rooms";
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String TYPE = "type";
    public static final String COST = "cost";
    public static final String BED_CAPACITY = "bedCapacity";
    public static final String MEAL = "meal";
    public static final String AIR_CONDITION = "aircondition";
    public static final String IMAGE = "image";
    public static final String CREATED_AT = "createdAt";
    public static final String UPDATED_AT = "updateAt";
}
