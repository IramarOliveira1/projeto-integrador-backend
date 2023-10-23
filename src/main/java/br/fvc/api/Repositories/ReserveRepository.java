package br.fvc.api.Repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.fvc.api.Models.Reserve;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {
    @Query("SELECT reserve FROM reserva AS reserve INNER JOIN reserve.usuario AS user INNER JOIN reserve.veiculo AS vehicle INNER JOIN vehicle.modelo AS model INNER JOIN reserve.seguro AS insurance INNER JOIN reserve.pagamento AS payment INNER JOIN payment.tipo_pagamento AS typePayment WHERE user.id = :id ORDER BY reserve.id DESC")
    Page<Reserve> findByIdReserve(Pageable page, Long id);

    @Query("SELECT r FROM reserva r WHERE r.id = :id")
    Reserve findByIdCodeReserve(Long id);

    @Query("SELECT reserve FROM reserva AS reserve INNER JOIN reserve.usuario AS user INNER JOIN reserve.veiculo AS vehicle INNER JOIN vehicle.modelo AS model INNER JOIN reserve.seguro AS insurance INNER JOIN reserve.pagamento AS payment INNER JOIN payment.tipo_pagamento AS typePayment WHERE reserve.status = :status AND user.id = :id ORDER BY reserve.id DESC")
    List<Reserve> findByStatus(String status, Long id);

    @Query("SELECT reserve FROM reserva AS reserve INNER JOIN reserve.usuario AS user INNER JOIN reserve.veiculo AS vehicle INNER JOIN vehicle.modelo AS model INNER JOIN reserve.seguro AS insurance INNER JOIN reserve.pagamento AS payment INNER JOIN payment.tipo_pagamento AS typePayment WHERE reserve.codigo_reserva = :code AND user.id = :id ORDER BY reserve.id DESC")
    List<Reserve> findByCodeReserve(Long code, Long id);
}
