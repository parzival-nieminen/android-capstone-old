package ch.theforce.capstone

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import ch.theforce.capstone.network.UnSplashHttpClient
import ch.theforce.capstone.utils.BlurHashDecoder
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val client: UnSplashHttpClient by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var photo = findViewById<ImageView>(R.id.photo)

        lifecycleScope.launch() {
            val randomPhoto = client.getRandomPhoto()
            val photoBitmap =
                BlurHashDecoder.decode(
                    randomPhoto.blur_hash,
                    randomPhoto.width / 3,
                    randomPhoto.height / 3
                )
            photo.setImageBitmap(photoBitmap)
            Picasso.get().load(randomPhoto.urls.full).into(photo)
        }
    }
}
