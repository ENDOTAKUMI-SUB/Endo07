package jp.ac.neec.it.k020c1094.endo07

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import jp.ac.neec.it.k020c1094.endo07.data.Money

/**
 * ゲームショップ画面
 *
 * @author ENDO Takumi
 */
class ShopGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_game)

        // 現在の残高を取得して表示
        val money = this.application as Money
        val tvMoneyValue = findViewById<TextView>(R.id.tvMoneyValue)
        tvMoneyValue.text = money.getMoneyInt().toString()

        // 商品一覧を定義
        val listView = findViewById<ListView>(R.id.lvShop1)
        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()
        var menu = mutableMapOf("name" to "アイテム名1", "price" to "800")
        menuList.add(menu)
        menu = mutableMapOf("name" to "アイテム名2", "price" to "850")
        menuList.add(menu)
        menu = mutableMapOf("name" to "アイテム名3", "price" to "860")
        menuList.add(menu)
        menu = mutableMapOf("name" to "アイテム名4", "price" to "870")
        menuList.add(menu)
        menu = mutableMapOf("name" to "アイテム名5", "price" to "880")
        menuList.add(menu)
        menu = mutableMapOf("name" to "アイテム名6", "price" to "890")
        menuList.add(menu)
        menu = mutableMapOf("name" to "アイテム名7", "price" to "900")
        menuList.add(menu)
        menu = mutableMapOf("name" to "アイテム名8", "price" to "910")
        menuList.add(menu)
        menu = mutableMapOf("name" to "アイテム名9", "price" to "920")
        menuList.add(menu)
        menu = mutableMapOf("name" to "アイテム名10", "price" to "930")
        menuList.add(menu)


        // リストビューをセット
        val from = arrayOf("name", "price")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        val adapter = SimpleAdapter(
            this@ShopGame,
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

            val intent = Intent(this@ShopGame, ConfirmationGameActivity::class.java)
            intent.putExtra("menuName", item["name"])
            intent.putExtra("menuPrice", item["price"])
            startActivity(intent)
            finish()
        }
    }
}