package com.example.myhealth.refeicao_alimento.repository;

import com.example.myhealth.refeicao_alimento.RefeicaoAlimento;
import com.example.myhealth.refeicao_alimento.RefeicaoAlimentoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RefeicaoAlimentoRepository extends JpaRepository<RefeicaoAlimento, RefeicaoAlimentoId> {

    @Query(value = "SELECT sum((a.proteina / a.porcao) * ra.porcao ) FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where r.data_refeicao BETWEEN ?1 AND ?2 and u.id_usuario = ?3 and r.categoria_refeicao_id = ?4 and cr.id_categoria_refeicao = r.categoria_refeicao_id and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and u.id_usuario = r.usuario_id", nativeQuery = true)
    Double somaProteina(LocalDateTime dataInicio, LocalDateTime LocalDateFim, Integer idUsuario, Integer idCategoriaRefeicao);

    @Query(value = "SELECT sum((a.colesterol / a.porcao) * ra.porcao ) FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where r.data_refeicao BETWEEN ?1 AND ?2 and u.id_usuario = ?3 and r.categoria_refeicao_id = ?4 and cr.id_categoria_refeicao = r.categoria_refeicao_id and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and u.id_usuario = r.usuario_id", nativeQuery = true)
    Double somaColesterol(LocalDateTime dataInicio, LocalDateTime LocalDateFim, Integer idUsuario, Integer idCategoriaRefeicao);

    @Query(value = "SELECT sum((a.carboidrato / a.porcao) * ra.porcao ) FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where r.data_refeicao BETWEEN ?1 AND ?2 and u.id_usuario = ?3 and r.categoria_refeicao_id = ?4 and cr.id_categoria_refeicao = r.categoria_refeicao_id and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and u.id_usuario = r.usuario_id", nativeQuery = true)
    Double somaCarboidrato(LocalDateTime dataInicio, LocalDateTime LocalDateFim, Integer idUsuario, Integer idCategoriaRefeicao);

    @Query(value = "SELECT sum((a.fibra / a.porcao) * ra.porcao ) FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where r.data_refeicao BETWEEN ?1 AND ?2 and u.id_usuario = ?3 and r.categoria_refeicao_id = ?4 and cr.id_categoria_refeicao = r.categoria_refeicao_id and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and u.id_usuario = r.usuario_id", nativeQuery = true)
    Double somaFibra(LocalDateTime dataInicio, LocalDateTime LocalDateFim, Integer idUsuario, Integer idCategoriaRefeicao);

    @Query(value = "SELECT sum((a.calcio / a.porcao) * ra.porcao ) FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where r.data_refeicao BETWEEN ?1 AND ?2 and u.id_usuario = ?3 and r.categoria_refeicao_id = ?4 and cr.id_categoria_refeicao = r.categoria_refeicao_id and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and u.id_usuario = r.usuario_id", nativeQuery = true)
    Double somaCalcio(LocalDateTime dataInicio, LocalDateTime LocalDateFim, Integer idUsuario, Integer idCategoriaRefeicao);

    @Query(value = "SELECT sum((a.ferro / a.porcao) * ra.porcao ) FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where r.data_refeicao BETWEEN ?1 AND ?2 and u.id_usuario = ?3 and r.categoria_refeicao_id = ?4 and cr.id_categoria_refeicao = r.categoria_refeicao_id and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and u.id_usuario = r.usuario_id", nativeQuery = true)
    Double somaFerro(LocalDateTime dataInicio, LocalDateTime LocalDateFim, Integer idUsuario, Integer idCategoriaRefeicao);

    @Query(value = "SELECT sum((a.sodio / a.porcao) * ra.porcao ) FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where r.data_refeicao BETWEEN ?1 AND ?2 and u.id_usuario = ?3 and r.categoria_refeicao_id = ?4 and  cr.id_categoria_refeicao = r.categoria_refeicao_id and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and u.id_usuario = r.usuario_id", nativeQuery = true)
    Double somaSodio(LocalDateTime dataInicio, LocalDateTime LocalDateFim, Integer idUsuario, Integer idCategoriaRefeicao);

    @Query(value = "SELECT sum((a.calorias / a.porcao) * ra.porcao ) FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where r.data_refeicao BETWEEN ?1 AND ?2 and u.id_usuario = ?3 and r.categoria_refeicao_id = ?4 and  cr.id_categoria_refeicao = r.categoria_refeicao_id and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and u.id_usuario = r.usuario_id", nativeQuery = true)
    Double somaCalorias(LocalDateTime dataInicio, LocalDateTime LocalDateFim, Integer idUsuario, Integer idCategoriaRefeicao);

    @Query(value = "SELECT case WHEN EXISTS ( SELECT * FROM Refeicao_alimento ra  where ra.id_refeicao = ?1) then CAST (1 AS BIT) ELSE CAST(0 AS BIT) END", nativeQuery = true)
    boolean refeicaoAlimentoExiste(Integer idRefeicao);

    @Query(value = "SELECT case WHEN EXISTS ( SELECT * FROM Refeicao ra, Usuario u  where ra.data_refeicao = ?1 and ra.categoria_refeicao_id = ?2 and u.id_usuario = ?3 and u.id_usuario = ra.usuario_id) then CAST (1 AS BIT) ELSE CAST(0 AS BIT) END", nativeQuery = true)
    boolean refeicaoExisteNaData(LocalDate dataInicio, Integer idCategoriaRefeicao, Integer idUsuario);

    @Query(value = "SELECT sum((a.calorias / a.porcao) * ra.porcao ) FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u where r.data_refeicao BETWEEN ?1 and ?2 and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and u.id_usuario = ?3", nativeQuery = true)
    Double somaCaloriasDia(LocalDateTime dataInicio, LocalDateTime LocalDateFim, Integer idUsuario);

    @Query(value = "SELECT * FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where u.id_usuario = ?1 and r.categoria_refeicao_id = 1 and cr.id_categoria_refeicao = r.categoria_refeicao_id and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento", nativeQuery = true)
    List<RefeicaoAlimento> buscarTodasRefeicoesUsuario(Integer idUsuario);

    @Query(value = "SELECT u.id_usuario, ra.*, r.*, a.*, cr.* FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where r.data_refeicao = ?1 and u.id_usuario = ?2 and r.categoria_refeicao_id = ?3 and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and cr.id_categoria_refeicao = r.categoria_refeicao_id and u.id_usuario = r.usuario_id", nativeQuery = true)
    List<RefeicaoAlimento> buscarTodasRefeicoesUsuarioByDay(LocalDate data, Integer idUsuario, Integer idCategoria);

    @Query(value = "SELECT u.id_usuario, ra.*, r.*, a.*, cr.* FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where r.id_refeicao = ?1 and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and cr.id_categoria_refeicao = r.categoria_refeicao_id and u.id_usuario = r.usuario_id", nativeQuery = true)
    List<RefeicaoAlimento> buscarAlimentos(Integer idRefeicao);

    @Query(value = "SELECT sum((a.calorias / a.porcao) * ra.porcao )  FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where r.data_refeicao BETWEEN ?1 AND ?2 and u.id_usuario = ?3 and cr.id_categoria_refeicao = r.categoria_refeicao_id and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and r.usuario_id = u.id_usuario", nativeQuery = true)
    Double somaCaloriasTodasCategorias(LocalDateTime dataInicio, LocalDateTime LocalDateFim, Integer idUsuario);

    @Query(value = "SELECT sum((a.proteina / a.porcao) * ra.porcao )  FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where r.data_refeicao BETWEEN ?1 AND ?2 and u.id_usuario = ?3 and cr.id_categoria_refeicao = r.categoria_refeicao_id and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and r.usuario_id = u.id_usuario", nativeQuery = true)
    Double somaProteinaTodasCategorias(LocalDateTime dataInicio, LocalDateTime LocalDateFim, Integer idUsuario);

    @Query(value = "SELECT sum((a.colesterol / a.porcao) * ra.porcao )  FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where r.data_refeicao BETWEEN ?1 AND ?2 and u.id_usuario = ?3 and cr.id_categoria_refeicao = r.categoria_refeicao_id and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and r.usuario_id = u.id_usuario", nativeQuery = true)
    Double somaColesterolTodasCategorias(LocalDateTime dataInicio, LocalDateTime LocalDateFim, Integer idUsuario);

    @Query(value = "SELECT sum((a.carboidrato / a.porcao) * ra.porcao )  FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where r.data_refeicao BETWEEN ?1 AND ?2 and u.id_usuario = ?3 and cr.id_categoria_refeicao = r.categoria_refeicao_id and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and r.usuario_id = u.id_usuario", nativeQuery = true)
    Double somaCarboidratoTodasCategorias(LocalDateTime dataInicio, LocalDateTime LocalDateFim, Integer idUsuario);

    @Query(value = "SELECT sum((a.fibra / a.porcao) * ra.porcao )  FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where r.data_refeicao BETWEEN ?1 AND ?2 and u.id_usuario = ?3 and cr.id_categoria_refeicao = r.categoria_refeicao_id and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and r.usuario_id = u.id_usuario", nativeQuery = true)
    Double somaFibraTodasCategorias(LocalDateTime dataInicio, LocalDateTime LocalDateFim, Integer idUsuario);

    @Query(value = "SELECT sum((a.calcio / a.porcao) * ra.porcao )  FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where r.data_refeicao BETWEEN ?1 AND ?2 and u.id_usuario = ?3 and cr.id_categoria_refeicao = r.categoria_refeicao_id and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and r.usuario_id = u.id_usuario", nativeQuery = true)
    Double somaCalcioTodasCategorias(LocalDateTime dataInicio, LocalDateTime LocalDateFim, Integer idUsuario);

    @Query(value = "SELECT sum((a.ferro / a.porcao) * ra.porcao )  FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where r.data_refeicao BETWEEN ?1 AND ?2 and u.id_usuario = ?3 and cr.id_categoria_refeicao = r.categoria_refeicao_id and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and r.usuario_id = u.id_usuario", nativeQuery = true)
    Double somaFerroTodasCategorias(LocalDateTime dataInicio, LocalDateTime LocalDateFim, Integer idUsuario);

    @Query(value = "SELECT sum((a.sodio / a.porcao) * ra.porcao )  FROM Refeicao_alimento ra, Refeicao r, Alimento a, Usuario u, Categoria_refeicao cr where r.data_refeicao BETWEEN ?1 AND ?2 and u.id_usuario = ?3 and cr.id_categoria_refeicao = r.categoria_refeicao_id and r.id_refeicao = ra.id_refeicao and ra.id_alimento = a.id_alimento and r.usuario_id = u.id_usuario", nativeQuery = true)
    Double somaSodioTodasCategorias(LocalDateTime dataInicio, LocalDateTime LocalDateFim, Integer idUsuario);


}