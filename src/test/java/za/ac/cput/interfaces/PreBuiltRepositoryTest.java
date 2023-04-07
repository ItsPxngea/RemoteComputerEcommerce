package za.ac.cput.interfaces;

/*
Test file for PreBuilt Repository
Author: Michael Johnson, 221094040
Date: 06/04/2023
*/


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.PreBuilt;
import za.ac.cput.factory.PreBuiltFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PreBuiltRepositoryTest {

    private static PreBuiltRepository repo = PreBuiltRepository.getRepo();
    private static PreBuilt p = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.", "5 Stars", "Graphics Card", "Gaming", "Valid", 4590);

    @Test
    void a_create() {
        PreBuilt created = repo.create(p);
        assertEquals(p.getBuildID(), p.getBuildID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        PreBuilt read = repo.read(p.getBuildID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        PreBuilt updated = new PreBuilt.Builder().copy(p)
                .setBuildType("Commercial")
                .setBuildWarranty("invalid")
                .build();
        assertNotNull(repo.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repo.delete(p.getBuildID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repo.getAll());
    }
}