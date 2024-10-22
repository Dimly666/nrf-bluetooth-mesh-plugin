package com.lebrislo.bluetooth.mesh.models

import android.bluetooth.BluetoothDevice
import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import no.nordicsemi.android.mesh.MeshBeacon
import no.nordicsemi.android.support.v18.scanner.ScanResult

class ExtendedBluetoothDevice : Parcelable {
    val device: BluetoothDevice?
    val scanResult: ScanResult?
    var name: String? = "Unknown"
    var rssi: Int
    var beacon: MeshBeacon? = null
        private set
    var provisioned: Boolean = false

    constructor(scanResult: ScanResult, beacon: MeshBeacon?) {
        this.scanResult = scanResult
        this.device = scanResult.device
        val scanRecord = scanResult.scanRecord
        if (scanRecord != null) {
            this.name = scanRecord.deviceName
        }
        this.rssi = scanResult.rssi
        this.beacon = beacon
    }

    constructor(scanResult: ScanResult) {
        this.scanResult = scanResult
        this.device = scanResult.device
        val scanRecord = scanResult.scanRecord
        if (scanRecord != null) {
            this.name = scanRecord.deviceName
        }
        this.rssi = scanResult.rssi
    }

    protected constructor(`in`: Parcel) {
        device = `in`.readParcelable(BluetoothDevice::class.java.classLoader)
        scanResult = `in`.readParcelable(ScanResult::class.java.classLoader)
        name = `in`.readString()
        rssi = `in`.readInt()
        beacon = `in`.readParcelable(MeshBeacon::class.java.classLoader)
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeParcelable(device, flags)
        dest.writeParcelable(scanResult, flags)
        dest.writeString(name)
        dest.writeInt(rssi)
        dest.writeParcelable(beacon, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    val address: String
        get() = device!!.address

    // Parcelable implementation
    fun matches(scanResult: ScanResult): Boolean {
        return device!!.address == scanResult.device.address
    }

    override fun equals(other: Any?): Boolean {
        if (other is ExtendedBluetoothDevice) {
            return device!!.address == other.device!!.address
        }
        return super.equals(other)
    }

    override fun hashCode(): Int {
        var result = device?.hashCode() ?: 0
        result = 31 * result + (scanResult?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + rssi
        result = 31 * result + (beacon?.hashCode() ?: 0)
        return result
    }

    companion object CREATOR : Creator<ExtendedBluetoothDevice> {
        override fun createFromParcel(parcel: Parcel): ExtendedBluetoothDevice {
            return ExtendedBluetoothDevice(parcel)
        }

        override fun newArray(size: Int): Array<ExtendedBluetoothDevice?> {
            return arrayOfNulls(size)
        }
    }
}
