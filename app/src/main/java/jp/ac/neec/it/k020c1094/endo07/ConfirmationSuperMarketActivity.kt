package jp.ac.neec.it.k020c1094.endo07

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import jp.ac.neec.it.k020c1094.endo07.data.Money

/**
 * 銀行の確認画面
 *
 * @author ENDO Takumi
 */
class ConfirmationSuperMarketActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation_super_market)

        // 値を取得
        val menuName = intent.getStringExtra("menuName")
        val menuPrice = intent.getStringExtra("menuPrice")

        // 現在の残高を取得・表示
        val money = this.application as Money
        val moneyValue: Int? = money.getMoneyInt()
        val tvMoneyValue = findViewById<TextView>(R.id.tvMoneyValue)
        tvMoneyValue.text = moneyValue.toString()

        // メッセージを表示
        val tvMsg = findViewById<TextView>(R.id.tvMsg)

        if (moneyValue!! - menuPrice!!.toInt() >= 0) { // 購入成功
            money.setMoneyInt(moneyValue!!.toInt() - menuPrice!!.toInt())
            tvMsg.text =
                "${getString(R.string.msg_success)} \n $menuName \n $menuPrice 円"

        } else { //残高不足
            tvMsg.text = getString(R.string.msg_ng)
        }

        findViewById<Button>(R.id.btBack).setOnClickListener(this)
    }

    /**
     * 各種ボタンのクリックイベント
     */
    override fun onClick(view: View) {
        when (view.id) {
            R.id.btBack -> {
                finish()
            }
        }
    }
}