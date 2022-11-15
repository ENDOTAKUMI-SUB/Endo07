package jp.ac.neec.it.k020c1094.endo07

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import jp.ac.neec.it.k020c1094.endo07.data.Money

/**
 * スーパーマーケット画面
 *
 * @author ENDO Takumi
 */
class ShopSuperMarketActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_super_market)

        // 現在の残高を取得して表示
        val money = this.application as Money
        val tvMoneyValue = findViewById<TextView>(R.id.tvMoneyValue)
        tvMoneyValue.text = money.getMoneyInt().toString()

        // クリックリスナをセット
        findViewById<Button>(R.id.btBack).setOnClickListener(this)


        // 商品一覧を定義
        val listView = findViewById<ListView>(R.id.lvShop1)
        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()
        var menu = mutableMapOf("name" to "アイテム名1", "price" to "100")
        menuList.add(menu)
        menu = mutableMapOf("name" to "アイテム名2", "price" to "250")
        menuList.add(menu)
        menu = mutableMapOf("name" to "アイテム名3", "price" to "360")
        menuList.add(menu)
        menu = mutableMapOf("name" to "アイテム名4", "price" to "470")
        menuList.add(menu)
        menu = mutableMapOf("name" to "アイテム名5", "price" to "580")
        menuList.add(menu)
        menu = mutableMapOf("name" to "アイテム名6", "price" to "10")
        menuList.add(menu)
        menu = mutableMapOf("name" to "アイテム名7", "price" to "20")
        menuList.add(menu)
        menu = mutableMapOf("name" to "アイテム名8", "price" to "30")
        menuList.add(menu)
        menu = mutableMapOf("name" to "アイテム名9", "price" to "40")
        menuList.add(menu)
        menu = mutableMapOf("name" to "アイテム名10", "price" to "1")
        menuList.add(menu)

        // リストビューをセット
        val from = arrayOf("name", "price")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        val adapter = SimpleAdapter(
            this@ShopSuperMarketActivity,
            menuList,
            android.R.layout.simple_list_item_2,
            from,
            to
        )
        listView.adapter = adapter
        listView.onItemClickListener = ListItemClickListener()
    }

    /**
     * リストがタップされたときの処理が記述されたメンバクラス。
     */
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            val item = parent.getItemAtPosition(position) as MutableMap<String, String>
            val intent =
                Intent(this@ShopSuperMarketActivity, ConfirmationSuperMarketActivity::class.java)
            intent.putExtra("menuName", item["name"])
            intent.putExtra("menuPrice", item["price"])
            startActivity(intent)
        }
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

    /**
     * 確認画面から戻ってきた際に所持金を更新する
     */
    override fun onStart() {
        val money = this.application as Money
        val moneyValue: Int? = money.getMoneyInt()

        val tvMoneyValue = findViewById<TextView>(R.id.tvMoneyValue)
        tvMoneyValue.text = moneyValue.toString()

        super.onStart()
    }
}