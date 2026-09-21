package com.vetcare.grupo_3.mapper;

import com.vetcare.grupo_3.Entity.Pago;
import com.vetcare.grupo_3.DTO.pagoDTO;
import com.vetcare.grupo_3.DTO.responseDTO.pagoResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PagoMapper {

    public Pago Entidad(pagoDTO dto) {
        Pago pago = new Pago();
        pago.setPrecio(dto.precio());
        pago.setMetodo(dto.metodo());
        pago.setEstado(dto.estado());
        return pago;
    }

    public pagoResponseDTO aResponse(Pago pago) {
        return new pagoResponseDTO(
                pago.getId(),
                pago.getPrecio(),
                pago.getMetodo(),
                pago.getEstado(),
                pago.getServicio() != null
                        ? pago.getServicio().getId()
                        : null
        );
    }

    public List<pagoResponseDTO> ResponseList(List<Pago> pagos) {
        return pagos.stream().map(this::aResponse).toList();
    }
}
