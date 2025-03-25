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

![Screenshot_20250325-160428](https://github.com/user-attachments/assets/440d69c1-a78f-41a5-a1e5-a72e709a3967) ![Screenshot_20250325-160440](https://github.com/user-attachments/assets/c3de2493-ba11-4f2f-99a9-2f8ffb155e43) ![Screenshot_20250325-160451](https://github.com/user-attachments/assets/554b8e74-5894-40ac-ac50-0e889c7fe5dd)



