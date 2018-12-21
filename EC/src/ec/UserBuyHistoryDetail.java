package ec;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BuyDataBeans;
import beans.ItemDataBeans;
import dao.BuyDAO;
import dao.BuyDetailDAO;

/**
 * 購入履歴画面
 * @author d-yamaguchi
 *
 */
@WebServlet("/UserBuyHistoryDetail")
public class UserBuyHistoryDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//自分で足したコード



					// パラメータとしてbuy_idを取得
		            int buyId = Integer.parseInt(request.getParameter("buy_id"));

					// 購入履歴一覧情報を取得
					BuyDAO buyDao = new BuyDAO();




					/* ====購入詳細ページ表示用==== */
					BuyDataBeans resultBDB = null;
					try {
						resultBDB = buyDao.getBuyDataBeansByBuyId(buyId);
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}

					request.setAttribute("resultBDB", resultBDB);


					// 購入アイテム情報
					ArrayList<ItemDataBeans> buyIDBList = null;
					try {
						buyIDBList = BuyDetailDAO.getItemDataBeansListByBuyId(buyId);
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					request.setAttribute("buyIDBList", buyIDBList);


					// リクエストスコープに購入履歴一覧情報をセット

					//request.setAttribute("detailList", detailList);




		//自分で足したコードここまで

		request.getRequestDispatcher(EcHelper.USER_BUY_HISTORY_DETAIL_PAGE).forward(request, response);




		//自分で足したコードここまで

	}
}
