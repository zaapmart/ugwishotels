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
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author KUFRE
 * @since Nov 14, 2023 3:11:28 PM
 */
public class RoomsDAO
{

    public static Room getRoombyId(int id) throws Exception
    {
        try( DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            return em.find(Room.class, id);
        }
    }

    public static List<Room> getAllRooms() throws Exception
    {
        try( DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            return em.createNativeQuery("SELECT * FROM " + ROOMS, Room.class).getResultList();
        }
    }
}
