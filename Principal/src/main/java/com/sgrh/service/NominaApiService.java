package com.sgrh.service;

import com.sgrh.dto.NominaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NominaApiService {

    @Autowired
    private RestTemplate restTemplate;

    public NominaResponse obtenerDatosNomina(Long empleadoId) {
        String url = "http://localhost:8081/nomina/api/" + empleadoId;
        return restTemplate.getForObject(url, NominaResponse.class);
    }
}

