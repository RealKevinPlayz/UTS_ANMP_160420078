package id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import id.ac.ubaya.informatika.anmp_uts_mobilehealthcare_160420078.model.Medicine

class MedicineListViewModel(application: Application): AndroidViewModel(application){
    val medicineLD = MutableLiveData<ArrayList<Medicine>>()
    val medicineLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh() {
        loadingLD.value = true
        medicineLoadErrorLD.value = false

        val medicinesJson = "[{'medicineId' : '1','medicineName' : 'Amoxicillin'," +
                "'medicineDesc' : 'Mengatasi infeksi bakteri, termasuk gonore, otitis media, atau infeksi ginjal (pielonefritis)'," +
                "'medicineDose' : 'Dewasa dan anak dengan BB ≥40 kg: 250–500 mg, tiap 8 jam atau 500–1.000 mg, tiap 12 jam. Untuk infeksi berat dosisnya adalah 750–1.000 mg, tiap 8 jam.'," +
                "'medicineComposition' : ' - '," +
                "'medicinePhotoUrl' : 'https://images.k24klik.com/product/large/apotek_online_k24klik_20211223092009359225_AMOXICILLIN-KF-500MG-TAB-100S-removebg-preview.png'," +
                "'medicineWarning' : 'Dapat menyebabkan perubahan rasa pada lidah, " +
                "mual atau muntah, sakit kepala, diare, dan ruam'}, " +
                "{'medicineId' : '2','medicineName' : 'Betadine'," +
                "'medicineDesc' : 'Obat pertolongan pertama yang digunakan untuk mencegah dan mengobati infeksi pada luka'," +
                "'medicineDose' : 'Oleskan ke kulit sesuai kebutuhan.'," +
                "'medicineComposition' : ' - '," +
                "'medicinePhotoUrl' : 'https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/14381/14381_1624258523.7964.jpg'," +
                "'medicineWarning' : 'Dapat menyebabkan gatal, ruam, bengkak pada kulit, nyeri pada vagina, iritasi pada kulit, mulut, atau bagian tubuh yang terkena Betadine.'}, " +
                "{'medicineId' : '3','medicineName' : 'Dopamine'," +
                "'medicineDesc' : 'Membantu kerja jantung dalam memompa darah saat terjadi syok'," +
                "'medicineDose' : 'Dosis awal dopamin suntik adalah 2–5 mcg/kgBB per menit yang diberikan melalui infus'," +
                "'medicineComposition' : ' - '," +
                "'medicinePhotoUrl' : 'https://www.pyfa.co.id/wp-content/uploads/2022/07/Dopamine-isi-50.jpg'," +
                "'medicineWarning' : 'Denyut jantung tidak teratur atau jantung berdebar, pusing yang berat hingga ingin pingsan, " +
                "sesak napas, dan nyeri dada'}, " +
                "{'medicineId' : '4','medicineName' : 'Mefinal'," +
                "'medicineDesc' : 'Obat ini dapat digunakan untuk Nyeri pada kondisi rematik, cedera jaringan lunak, kondisi muskuloskeletal menyakitkan lainnya, dismenorea, sakit kepala, sakit gigi, nyeri pasca operasi'," +
                "'medicineDose' : 'Dewasa dan anak > 14 tahun : 3 x sehari 500 mg'," +
                "'medicineComposition' : ' - '," +
                "'medicinePhotoUrl' : 'https://d2qjkwm11akmwu.cloudfront.net/products/4969-1665771575.webp'," +
                "'medicineWarning' : 'Ggn & perdarahan GI, tukak peptik'}," +
                "{'medicineId' : '5','medicineName' : 'Lodia'," +
                "'medicineDesc' : 'Obat ini dapat digunakan untuk mengobati diare akut dan kronis'," +
                "'medicineDose' : '2 tab, diikuti 1 tab setelah setiap tinja yang tidak berbentuk. Diare kronis 2-4 tab/hari dalam dosis terbagi. Maks: 8 tab setiap hari'," +
                "'medicineComposition' : ' - '," +
                "'medicinePhotoUrl' : 'https://d2qjkwm11akmwu.cloudfront.net/products/289-1.webp'," +
                "'medicineWarning' : 'Sakit perut, megakolon toksik, pusing, kelelahan, ruam kulit'}]"

        val sType = object : TypeToken<ArrayList<Medicine>>() { }.type
        val result = Gson().fromJson<ArrayList<Medicine>>(medicinesJson, sType)

        medicineLD.value = result
        medicineLoadErrorLD.value = false
        loadingLD.value = false
    }

    override fun onCleared() {
        super.onCleared()
    }


}