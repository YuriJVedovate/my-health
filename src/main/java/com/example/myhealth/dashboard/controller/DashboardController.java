package com.example.myhealth.dashboard.controller;

import com.example.myhealth.dashboard.CaloriasDiaResponse;
import com.example.myhealth.dashboard.Conversao;
import com.example.myhealth.dashboard.Gramas;
import com.example.myhealth.peso.Peso;
import com.example.myhealth.peso.repository.PesoRepository;
import com.example.myhealth.refeicao.repository.RefeicaoRepository;
import com.example.myhealth.refeicao_alimento.repository.RefeicaoAlimentoRepository;
import com.example.myhealth.usuario.Usuario;
import com.example.myhealth.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/dashboards")
public class DashboardController {

    @Autowired
    private RefeicaoAlimentoRepository repositoryRefeicaoAlimento;

    @Autowired
    private RefeicaoRepository repositoryRefeicao;

    @Autowired
    private UsuarioRepository repositoryUsuario;

    @Autowired
    private PesoRepository repositoryPeso;

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @GetMapping("/somaNutrientes")
    public ResponseEntity somaElemento(
            @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,
            @RequestParam Integer idUsuario,
            @RequestParam int idCategoriaRefeicao) {
        LocalDateTime dtStart = data.atStartOfDay();
        LocalDateTime dtFinish = data.atTime(LocalTime.MAX);
        Conversao conveter = new Conversao();

        if (repositoryUsuario.existsById(idUsuario) && repositoryRefeicaoAlimento.refeicaoExisteNaData(data, idCategoriaRefeicao, idUsuario)) {

            if (repositoryRefeicaoAlimento.somaColesterol(dtStart, dtFinish, idUsuario, idCategoriaRefeicao) / conveter.getPesoColesterol() < 0)return ResponseEntity.notFound().build();

            Gramas gramas = new Gramas(
                    repositoryRefeicaoAlimento.somaColesterol(dtStart, dtFinish, idUsuario, idCategoriaRefeicao) / conveter.getPesoColesterol(),
                    repositoryRefeicaoAlimento.somaCarboidrato(dtStart, dtFinish, idUsuario, idCategoriaRefeicao) / conveter.getPesoCarboidrato(),
                    repositoryRefeicaoAlimento.somaFibra(dtStart, dtFinish, idUsuario, idCategoriaRefeicao) / conveter.getPesoFibra(),
                    repositoryRefeicaoAlimento.somaCalcio(dtStart, dtFinish, idUsuario, idCategoriaRefeicao) / conveter.getPesoCalcio(),
                    repositoryRefeicaoAlimento.somaFerro(dtStart, dtFinish, idUsuario, idCategoriaRefeicao) / conveter.getPesoFerro(),
                    repositoryRefeicaoAlimento.somaSodio(dtStart, dtFinish, idUsuario, idCategoriaRefeicao) / conveter.getPesoSodio(),
                    repositoryRefeicaoAlimento.somaProteina(dtStart, dtFinish, idUsuario, idCategoriaRefeicao) / conveter.getPesoProteina(),
                    repositoryRefeicaoAlimento.somaCalorias(dtStart, dtFinish, idUsuario, idCategoriaRefeicao));
            return ResponseEntity.status(200).body(gramas);
        }
        return ResponseEntity.notFound().build();
    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @GetMapping("caloriasDia")
    public ResponseEntity getCaloriasDia(@RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data, Integer idUsuario) {
        LocalDateTime dtStart = data.atStartOfDay();
        LocalDateTime dtFinish = data.atTime(LocalTime.MAX);

        if (!(data.isAfter(LocalDate.now()) && repositoryUsuario.existsById(idUsuario))) {
            Usuario user = repositoryUsuario.getOne(idUsuario);
            CaloriasDiaResponse response = new CaloriasDiaResponse();

            if (repositoryRefeicaoAlimento.somaCaloriasDia(dtStart, dtFinish, idUsuario) == null) return ResponseEntity.status(404).build();

            response.setConsumoTotalDia(((11.65 * user.getPeso()) + (3.42 * user.getAltura()) - (5.72 * (LocalDate.now().getYear() - user.getDataNascimento().getYear()))) * 1.3);
            response.setConsumidoDia(repositoryRefeicaoAlimento.somaCaloriasDia(dtStart, dtFinish, idUsuario));

            return ResponseEntity.status(200).body(response);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @GetMapping("caloriasIntervalo")
    public ResponseEntity getCaloriasIntervalo(@RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
                                               @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
                                               Integer idUsuario) {

        LocalDateTime dtStart = dataInicio.atStartOfDay();
        LocalDateTime dtFinish = dataFim.atTime(LocalTime.MAX);

        if (dataFim.isAfter(LocalDate.now()) && repositoryUsuario.existsById(idUsuario)) {
            return ResponseEntity.status(200).body(repositoryRefeicaoAlimento.somaCaloriasDia(dtStart, dtFinish, idUsuario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @GetMapping("historico-peso")
    public ResponseEntity getHistoricoPeso(@RequestParam int id) {
        List<Peso> pesos = repositoryPeso.historicoPeso(id);
        if (pesos.isEmpty()){
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.ok(pesos);
        }
    }

}
