package Services;

import DAO.TransaksiDAO;
import Model.Transaksi;

import java.util.List;

public class TransaksiService {
    private TransaksiDAO dao = new TransaksiDAO();

    public List<Transaksi> getAllTransaksi() {
        return dao.getAllTransaksi();
    }

    public void tambahTransaksi(Transaksi t) {
        dao.insertTransaksi(t);
    }
}

