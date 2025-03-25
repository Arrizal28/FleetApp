# Fleet Management App

Fleet Management App adalah aplikasi Android berbasis Kotlin dengan Jetpack Compose yang digunakan untuk memantau kendaraan dalam sebuah armada. Aplikasi ini menampilkan peta dengan kendaraan yang bergerak, dashboard sensor real-time, dan event alerts. Data disimulasikan menggunakan lokal background service.

## Fitur Utama
- **Live Tracking**: Menampilkan posisi kendaraan di peta secara real-time.
- **Dashboard Sensor**: Menampilkan informasi sensor kendaraan seperti kecepatan, Engine status (on/off), dan Door status (open/close).
- **Event Alerts**: Notifikasi untuk kejadian penting seperti kecepatan berlebih atau peringatan pemeliharaan.

## Persyaratan
- Android Studio terbaru
- Kotlin dan Jetpack Compose
- API Key Google Maps
- Koneksi internet untuk mendapatkan data real-time

## Instalasi
1. Clone repository ini:
   ```bash
   git clone https://github.com/username/fleet-management-app.git
   ```
2. Buka project dengan Android Studio.
3. Tambahkan **Google Maps API Key** di `AndroidManifest.xml`:
   ```xml
   <meta-data
       android:name="com.google.android.geo.API_KEY"
       android:value="YOUR_API_KEY_HERE" />
   ```
4. Jalankan aplikasi menggunakan emulator atau perangkat fisik.

## Screenshot
![Desain tanpa judul (4)](https://github.com/user-attachments/assets/16c01def-94ee-4628-b8f5-3ed9402ba96d)





