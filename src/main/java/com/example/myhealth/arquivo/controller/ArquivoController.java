//package com.example.myhealth.arquivo.controller;
//
//import com.example.myhealth.alimento.repository.AlimentoRepository;
//import com.example.myhealth.arquivo.FileExporter;
//import com.example.myhealth.arquivo.GravaArquivo;
//import com.example.myhealth.dashboard.Conversao;
//import com.example.myhealth.dashboard.Gramas;
//import com.example.myhealth.objetos.FilaObj;
//import com.example.myhealth.refeicao_alimento.repository.RefeicaoAlimentoRepository;
//import com.example.myhealth.usuario.repository.UsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.InputStreamResource;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.nio.file.Path;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.Date;
//
//@RestController
//@RequestMapping("/gerarArquivo")
//public class ArquivoController {
//
//    @Autowired
//    private AlimentoRepository repository;
//
//    @Autowired
//    private UsuarioRepository repositoryUsuario;
//
//    @Autowired
//    RefeicaoAlimentoRepository repositoryRefeicaoAlimento;
//
//    @Autowired
//    private FileExporter fileExporter;
//
//    // @CrossOrigin(origins = "http://54.173.23.9/")
//    @RequestMapping(path = "/download", method = RequestMethod.GET)
//    public ResponseEntity<InputStreamResource> gerarArquivoAlimento(
//            @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,
//            @RequestParam Integer idUsuario) throws FileNotFoundException {
//
//        HttpHeaders headers = new HttpHeaders();
//        LocalDateTime dtStart = data.atStartOfDay();
//        LocalDateTime dtFinish = data.atTime(LocalTime.MAX);
//        FilaObj<Gramas> fila = new FilaObj<>(1);
//        Conversao conveter = new Conversao();
//        String fileContent = "";
//        if (!(data.isAfter(LocalDate.now())) && repositoryUsuario.existsById(idUsuario)) {
//            Gramas gramas = new Gramas(
//                    repositoryRefeicaoAlimento.somaColesterolTodasCategorias(dtStart, dtFinish, idUsuario) / conveter.getPesoColesterol(),
//                    repositoryRefeicaoAlimento.somaCarboidratoTodasCategorias(dtStart, dtFinish, idUsuario) / conveter.getPesoCarboidrato(),
//                    repositoryRefeicaoAlimento.somaFibraTodasCategorias(dtStart, dtFinish, idUsuario) / conveter.getPesoFibra(),
//                    repositoryRefeicaoAlimento.somaCalcioTodasCategorias(dtStart, dtFinish, idUsuario) / conveter.getPesoCalcio(),
//                    repositoryRefeicaoAlimento.somaFerroTodasCategorias(dtStart, dtFinish, idUsuario) / conveter.getPesoFerro(),
//                    repositoryRefeicaoAlimento.somaSodioTodasCategorias(dtStart, dtFinish, idUsuario) / conveter.getPesoSodio(),
//                    repositoryRefeicaoAlimento.somaProteinaTodasCategorias(dtStart, dtFinish, idUsuario) / conveter.getPesoProteina(),
//                    repositoryRefeicaoAlimento.somaCaloriasTodasCategorias(dtStart, dtFinish, idUsuario));
//            System.out.println(gramas);
//            fila.insert(gramas);
//        }
//
//        long contagemRegistros = repository.count();
//
//        String nomeArquivo = "RelatorioDiario.csv";
//        String header = "";
//        String corpo = "";
//        String trailer = "";
//
//
//        Date dataDeHoje = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        header = header + "00RELATORIO";
//        header = header + formatter.format(dataDeHoje);
//        header = header + "01";
//        fileContent+= header;
//        fileContent+= "\n";
////        GravaArquivo.gravaRegistro("RelatorioDiario.csv", header);
//        int contRegDados = 0;
//
//        for (int i = 0; i < fila.getTamanho(); i++) {
//            Gramas gramas = fila.poll();
//            corpo = "02";
//            corpo += String.format(";%.8f", gramas.getTotalCalorias());
//            corpo += String.format(";%.8f", gramas.getTotalCarboidrato());
//            corpo += String.format(";%.8f", gramas.getTotalProteina());
//            corpo += String.format(";%.8f", gramas.getTotalColesterol());
//            corpo += String.format(";%.8f", gramas.getTotalFibra());
//            corpo += String.format(";%.8f", gramas.getTotalCalcio());
//            corpo += String.format(";%.8f", gramas.getTotalFerro());
//            corpo += String.format(";%.8f", gramas.getTotalSodio());
//            fileContent+= corpo;
//            fileContent+= "\n";
//            contRegDados++;
//
////            GravaArquivo.gravaRegistro("RelatorioDiario.csv", corpo);
//            System.out.println(i);
//
//        }
//
//        trailer = trailer + "01";
//        trailer = trailer + String.format("%05d", Integer.valueOf(contRegDados));
//        fileContent+= trailer;
////        GravaArquivo.gravaRegistro("RelatorioDiario.csv", trailer);
//        Path exportedPath = fileExporter.export(fileContent, nomeArquivo);
//        File exportedFile = exportedPath.toFile();
//        FileInputStream fileInputStream = new FileInputStream(exportedFile);
//        InputStreamResource inputStreamResource = new InputStreamResource(fileInputStream);
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + nomeArquivo)
//                .contentType(MediaType.TEXT_PLAIN)
//                .contentLength(exportedFile.length())
//                .body(inputStreamResource);
//
//
//    }
//}
//
