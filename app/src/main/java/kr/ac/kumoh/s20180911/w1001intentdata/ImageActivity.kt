package kr.ac.kumoh.s20180911.w1001intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import kr.ac.kumoh.s20180911.w1001intentdata.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity(), OnClickListener {
    companion object {
        const val imageName = "image"
        const val resultName = "result"

        const val LIKE = 10
        const val DISLIKE = 20
        const val NONE = 0
    }

    private lateinit var binding: ActivityImageBinding
    private var image: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Toast.makeText(this, intent.getStringExtra("image"), Toast.LENGTH_LONG).show()

        image = intent.getStringExtra(MainActivity.keyName)
        val res = when (image) {
            "gundam" -> R.drawable.abocado
            "zaku" -> R.drawable.branch
            else -> R.drawable.ic_launcher_foreground
        }
        binding.imgGundam.setImageResource(res)

        binding.btnLike.setOnClickListener(this)
        binding.btnDislike.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent()
        val value = when (v?.id) {
            binding.btnLike.id -> LIKE
            binding.btnDislike.id -> DISLIKE
            else -> NONE
        }
        intent.putExtra(imageName, image)
        intent.putExtra(resultName, value)
        setResult(RESULT_OK, intent)
        finish() // activity 종료
    }
}