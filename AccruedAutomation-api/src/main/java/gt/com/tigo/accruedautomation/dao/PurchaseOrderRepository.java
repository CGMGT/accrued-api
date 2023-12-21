package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.PurchaseOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrderEntity, Long>, JpaSpecificationExecutor<PurchaseOrderEntity> {

    @Query(
            value = "SELECT f_get_email_recipients(?,?)",
            nativeQuery = true
    )
    String getRecipients(String grupo, String origen);

    @Query(
            value = "SELECT getEmailTemplate(?)",
            nativeQuery = true
    )
    String getEmailTemplate(String nombre);

    @Query(
            value = "SELECT getEmailSubject(?)",
            nativeQuery = true
    )
    String getEmailSubject(String nombre);

    @Query(
            value = "SELECT getConfirmacionData(?,?,?)",
            nativeQuery = true
    )
    String getConfirmationData(Long id, String comentarios, String estado);

    @Query(
            value = "SELECT getConfirmacionData(?,?)",
            nativeQuery = true
    )
    String getConfirmationData(Long id, String estado);

    @Query(
            value = "SELECT getReasignacionData(?,?)",
            nativeQuery = true
    )
    String getReasignacionData(Long id, String data);

    @Query(
            value = "SELECT STATUS, COUNT(*)CANTIDAD,\n" +
                    "       CASE STATUS\n" +
                    "\t   \tWHEN 'CONFIRMADA' THEN '#0DA2DC'\n" +
                    "\t\tWHEN 'VIGENTE' THEN '#3ac47d'\n" +
                    "\t\tWHEN 'POR VENCER' THEN '#FECA00'\n" +
                    "\t\tWHEN 'VENCIDO' THEN '#d92550'\n" +
                    "\t   END COLOR\n" +
                    " FROM PURCHASE_ORDER\n" +
                    " WHERE USUARIO_REQUESTER = (SELECT CORREO_ELECTRONICO FROM ADM_USUARIO WHERE ID = ? LIMIT 1)\n" +
                    " GROUP BY STATUS",
            nativeQuery = true
    )
    List<Object> getData4PoChart(Long usuario);

    @Query(
            value = "SELECT STATUS, SUM(MONTO)MONTO, SUM(MONTO_GTQ)MONTO_GTQ\n" +
                    "  FROM(\n" +
                    "SELECT STATUS,case moneda when 'USD' then sum(ABS(monto)) else 0 end MONTO,  \n" +
                    " case moneda when 'GTQ' then sum(ABS(monto_gtq)) else 0 end MONTO_GTQ \n" +
                    " FROM PURCHASE_ORDER\n" +
                    " WHERE USUARIO_REQUESTER = (SELECT CORREO_ELECTRONICO FROM ADM_USUARIO WHERE ID = ? LIMIT 1)\n" +
                    " GROUP BY STATUS,MONEDA\n" +
                    " )T\n" +
                    " GROUP BY STATUS",
            nativeQuery = true
    )
    List<Object> getData4PobyAmount(Long usuario);

    @Query(
            value = "SELECT fUpdateRequester(?,?,?,?,?)",
            nativeQuery = true
    )
    String updateRequester(Long id, String _nombre_requester, String _usuario_requester,
                           String _nombre_jefe_owner, String _usuario_jefe_owner);

    @Query(
            value = "SELECT * \n" +
                    " FROM f_db_kpi_general(?)t" ,
            nativeQuery = true
    )
    List<Object> getData4KpiGeneral(String origen);

    @Query(
            value = "SELECT * \n" +
                    " FROM F_DB_SALDO_ESTADO_EMPRESA(?)T" ,
            nativeQuery = true
    )
    List<Object> getData4SaldoEstadoEmpresa(String origen);

    @Query(
            value = "SELECT * \n" +
                    " FROM F_DB_ANTIGUEDAD_ACCIONES(?)T" ,
            nativeQuery = true
    )
    List<Object> getData4AntiguedadAcciones(String origen);

    @Query(
            value = "SELECT * \n" +
                    " FROM F_DB_SALDO_VENCIDO_PROVEEDOR(?)T" ,
            nativeQuery = true
    )
    List<Object> getData4SaldoVencidoProveedor(String origen);

    @Query(
            value = "SELECT * \n" +
                    " FROM F_DB_SALDO_VENCIDO_REQUESTER(?)T" ,
            nativeQuery = true
    )
    List<Object> getData4SaldoVencidoRequester(String origen);

    @Query(
            value = "SELECT * \n" +
                    " FROM F_DB_OPEX_CAPEX(?)T" ,
            nativeQuery = true
    )
    List<Object> getData4OpexCapex(String origen);

    @Query(
            value = "SELECT * \n" +
                    " FROM f_db_estados_justificacion(?,?)T" ,
            nativeQuery = true
    )
    List<Object> getData4EstadosJustificaciones(String origen, String usuario);

    @Query(
            value = "SELECT * \n" +
                    " FROM f_DB_TOTAL_KPIS_EMPRESA(?,?)T" ,
            nativeQuery = true
    )
    List<Object> getData4totalkpiempresa(Long usuario, String empresa);

    @Query(
            value = "SELECT * \n" +
                    " FROM f_DB_DETALLE_KPIS_EMPRESA(?)T" ,
            nativeQuery = true
    )
    List<Object> getData4detallekpiempresa(Long usuario);

    @Query(
            value = "SELECT * \n" +
                    " FROM f_db_get_empresas()T" ,
            nativeQuery = true
    )
    List<Object> getEmpresas();
}
