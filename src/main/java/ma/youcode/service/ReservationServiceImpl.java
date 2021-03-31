package ma.youcode.service;

import ma.youcode.dao.ReservationDao;
import ma.youcode.model.Reservation;
import ma.youcode.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation getReservation(Long idReservation) {
        return reservationDao.getReservation(idReservation);
    }

    @Override
    public void addReservation(Reservation reservation) {
        reservationDao.addReservation(reservation);
    }

    @Override
    public void updateReservation(Reservation reservation, Long idReservation) {
        reservationDao.updateReservation(reservation, idReservation);
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        reservationDao.deleteReservation(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationDao.getAllReservations();
    }

    @Override
    public List<Reservation> getAcceptedReservations(Long idUser) {
        return reservationRepository.getAcceptedReservations(idUser);
    }

    @Override
    public List<Reservation> getNonAcceptedReservations(Long idUser) {
        return reservationRepository.getNonAcceptedReservations(idUser);
    }

    @Override
    public List<Reservation> getAllReservationsOfUser(Long idUser) {
        return reservationRepository.getAllReservationsOfUser(idUser);
    }

    @Override
    public Long countUsersReservationsInParticularDay(Date date) {
        return reservationRepository.countUsersReservationsInParticularDay(date);
    }

    @Override
    public BigInteger countReservationsBetweenNowAndLast7Days(Long idUser) {
        return reservationRepository.countReservationsBetweenNowAndLast7Days(idUser);
    }

    @Override
    public Long countAcceptedReservationsForUser(Date date, Long idUser) {
        return reservationRepository.countAcceptedReservationsForUser(date, idUser);
    }

    @Override
    public Long countNotAcceptedReservationsForUser(Date date, Long idUser) {
        return reservationRepository.countNotAcceptedReservationsForUser(date, idUser);
    }
}
