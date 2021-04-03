package ch.theforce.capstone

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import ch.theforce.capstone.network.UnSplashHttpClient
import ch.theforce.capstone.utils.BlurHashDecoder
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val client: UnSplashHttpClient by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var photo = findViewById<ImageView>(R.id.photo)

        lifecycleScope.launch() {
            val response = client.getRandomImage()
            var photoBitmap =
                BlurHashDecoder.decode(response.blur_hash, response.width / 3, response.height / 3)
            photo.setImageBitmap(photoBitmap)
        }
    }
}
