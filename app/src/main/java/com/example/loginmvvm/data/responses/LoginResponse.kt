package com.example.loginmvvm.data.responses


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    val `data`: LoginData,
    @SerializedName("message")
    val message: String, // Login Success
    @SerializedName("status")
    val status: Int // 1
)

@Entity(tableName = "LoginData")
data class LoginData(
    @SerializedName("changePassword")
    val changePassword: Boolean, // false
    @SerializedName("last_login")
    val lastLogin: String, // 2023-06-05 12:49:58
    @SerializedName("maxCollaterals")
    val maxCollaterals: String, // 3
    @SerializedName("maxGuarantors")
    val maxGuarantors: String, // 3
    @SerializedName("maxHouseholdMembers")
    val maxHouseholdMembers: String, // 3
    @SerializedName("securityQuestionsSet")
    val securityQuestionsSet: Boolean, // true
    //@SerializedName("token")
    //val token: String?, // eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImp0aSI6ImQ2NDkyODU2YTRhNGMxMDQ2ODFkZTRmM2EyZTBmOTg5MSJ9.eyJuYW1lIjoiRGFuaWVsIEtpbWFuaSIsInVzZXJuYW1lIjoiOTdNMFkxMkJOV0VKQVFQIiwiZGV2aWNlSWQiOm51bGwsImlzcyI6Imh0dHBzOlwvXC90ZXN0LWFwaS5la2VueWEuY28ua2UiLCJhdWQiOiJodHRwczpcL1wvdGVzdC1hcGkuZWtlbnlhLmNvLmtlIiwianRpIjoiZDY0OTI4NTZhNGE0YzEwNDY4MWRlNGYzYTJlMGY5ODkxIiwiaWF0IjoxNjg1OTU4NzkyLCJleHAiOjE2ODYwNDUxOTIsInVpZCI6NzI1fQ.Iu1fy1N-8aMo2ftJkvh8qt9Pscb8B42u_VWgFSv9I-g
    @SerializedName("user")
    @Embedded(prefix = "userdata_")
    val user: UserData
) {

    @SerializedName("token")
    @Ignore
    var token: String? = null
}

data class UserData(
    @SerializedName("dob")
    val dob: String, // 1995-02-01
    @SerializedName("email")
    val email: String, // kimani.daniel@eclectics.io
    @SerializedName("idNumber")
    val idNumber: String, // 631052033X47
    @SerializedName("name")
    val name: String, // Daniel Kimani
    @SerializedName("passportDocUrl")
    val passportDocUrl: String, // https://test-portal.ekenya.co.ke/moneymart-tijara/uploads/organizations/013/clients/Daniel/631052033X47/passport-photo.png
    @SerializedName("phone")
    val phone: String, // 254798997948
    @SerializedName("username")
    val username: String // 97M0Y12BNWEJAQP
)

