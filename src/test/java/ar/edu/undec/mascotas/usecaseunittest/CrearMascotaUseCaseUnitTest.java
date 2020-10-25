package ar.edu.undec.mascotas.usecaseunittest;

import Mockito.MockitoExtension;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.repositorio.ICrearMascotaRepositorio;
import ar.edu.undec.mascotas.usecase.CrearMascotaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;


import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class CrearMascotaUseCaseUnitTest {

    @Mock
    ICrearMascotaRepositorio crearMascotaRepositorio;

    @Test
    void CrearMascota_mascotaNoExiste_CreaMascota(){
        //Arrange
        Mascota laMascota = Mascota.instancia("Coty","Labrador", LocalDate.of(2005,1,1));
        CrearMascotaUseCase crearMascotaUseCase = new CrearMascotaUseCase(crearMascotaRepositorio);

        //Simulo Base de datos
        when(crearMascotaRepositorio.existe(laMascota.getNombre())).thenReturn(false);
        when(crearMascotaRepositorio.guardarMascota(laMascota)).thenReturn(true);



        //Act
        boolean resultado = crearMascotaUseCase.crearMascota(laMascota);
        boolean resultado2 = crearMascotaUseCase.crearMascota(laMascota);

        //Assert
        Assertions.assertTrue(resultado);
        Assertions.assertTrue(resultado2);

    }
}
