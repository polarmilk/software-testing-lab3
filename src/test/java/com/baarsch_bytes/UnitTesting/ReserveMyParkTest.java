package com.baarsch_bytes.UnitTesting;

import com.baarsch_bytes.Exceptions.ReservationException;
import com.baarsch_bytes.Exceptions.GuestAgeReservationException;
import com.baarsch_bytes.Exceptions.NightReservationException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReserveMyParkTest {

    private final ReserveMyPark park = new ReserveMyPark();

    // TC1: BVA1.1 - Just below min stay
    @Test
    void shouldThrowExceptionForJustBelowMinimumStay() {
        assertThrows(NightReservationException.class, () -> {
            park.calculateStayPrice(0, 26, false, false);
        });
    }

    // TC2: BVA1.2, Resident Flag = F, Veteran Flag = F - Min stay, not res or vet
    @Test
    void shouldCalculateMinimumStayForNonResidentNonVeteran() throws Exception {
        double result = park.calculateStayPrice(1, 26, false, false);

        assertEquals(50.0, result, 0.001);
    }

    // TC3: BVA1.3 - Max stay
    @Test
    void shouldCalculateMaximumStay() throws Exception {
        double result = park.calculateStayPrice(14, 26, false, false);

        assertEquals(700.0, result, 0.001);
    }

    // TC4: BVA1.4 - Above max stay
    @Test
    void shouldThrowExceptionForJustAboveMaximumStay() {
        assertThrows(NightReservationException.class, () -> {
            park.calculateStayPrice(15, 26, false, false);
        });
    }

    // TC5: BVA2.1, EP2.1 - Just below min valid age
    @Test
    void shouldThrowExceptionForJustBelowMinimumValidAge() {
        assertThrows(GuestAgeReservationException.class, () -> {
            park.calculateStayPrice(1, -1, false, false);
        });
    }

    // TC6: BVA2.2, EP2.2 - Min age child
    @Test
    void shouldApplyChildDiscountAtMinimumAge() throws Exception {
        double result = park.calculateStayPrice(1, 0, false, false);

        assertEquals(25.0, result, 0.001);
    }

    // TC7: BVA2.3, EP2.2 - Max age child
    @Test
    void shouldApplyChildDiscountAtMaximumChildAge() throws Exception {
        double result = park.calculateStayPrice(1, 12, false, false);

        assertEquals(25.0, result, 0.001);
    }

    // TC8: BVA2.4, EP2.3 - Min age adult
    @Test
    void shouldApplyFullPriceAtMinimumAdultAge() throws Exception {
        double result = park.calculateStayPrice(1, 13, false, false);

        assertEquals(50.0, result, 0.001);
    }

    // TC9: BVA2.5, EP2.3 - Max age adult
    @Test
    void shouldApplyFullPriceAtMaximumAdultAge() throws Exception {
        double result = park.calculateStayPrice(1, 64, false, false);

        assertEquals(50.0, result, 0.001);
    }

    // TC10: BVA2.6, EP2.4 - Min age senior
    @Test
    void shouldApplySeniorDiscountAtMinimumSeniorAge() throws Exception {
        double result = park.calculateStayPrice(1, 65, false, false);

        assertEquals(40.0, result, 0.001);
    }

    // TC11: Resident Flag = T, Veteran Flag = T
    @Test
    void shouldApplyResidentAndVeteranDiscounts() throws Exception {
        double result = park.calculateStayPrice(1, 26, true, true);

        assertEquals(36.0, result, 0.001);
    }

    // TC12: Resident Flag = T, Veteran Flag = F
    @Test
    void shouldApplyResidentDiscountOnly() throws Exception {
        double result = park.calculateStayPrice(1, 26, true, false);

        assertEquals(40.0, result, 0.001);
    }

    // TC13: Resident Flag = F, Veteran Flag = T
    @Test
    void shouldApplyVeteranDiscountOnly() throws Exception {
        double result = park.calculateStayPrice(1, 26, false, true);

        assertEquals(45.0, result, 0.001);
    }
}
