package bompard.lancelot.iimdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_author.*

class AuthorFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_author, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Auteur Info Perso
        val auteurName = arguments!!.getString("AuteurName")
        val auteurUserName = arguments!!.getString("AuteurUserName")
        val auteurEmail = arguments!!.getString("AuteurEmail")
        val auteurPhone = arguments!!.getString("AuteurPhone")
        val auteurWebsite = arguments!!.getString("AuteurWebsite")
        //Auteur Info Address
        val auteurAdrStreet = arguments!!.getString("AuteurAdrStreet")
        val auteurAdrSuite = arguments!!.getString("AuteurAdrSuite")
        val auteurAdrCity = arguments!!.getString("AuteurAdrCity")
        val auteurAdrZipcode = arguments!!.getString("AuteurAdrZipcode")
        val auteurAdrLat = arguments!!.getString("AuteurAdrLat")
        val auteurAdrLng = arguments!!.getString("AuteurAdrLng")
        //Auteur Info Company
        val auteurCpnName = arguments!!.getString("AuteurCpnName")
        val auteurCpnCatchPhrase = arguments!!.getString("AuteurCpnCatchPhrase")
        val auteurCpnBs = arguments!!.getString("AuteurCpnBs")

        //TextView Info Perso
        auteur_name.text = auteurName
        auteur_username.text = auteurUserName
        auteur_email.text = auteurEmail
        auteur_phone.text = auteurPhone
        auteur_website.text = auteurWebsite
        //TextView Info Address
        auteur_address_street.text = auteurAdrStreet
        auteur_address_suite.text = auteurAdrSuite
        auteur_address_city.text = auteurAdrCity
        auteur_address_zipcode.text = auteurAdrZipcode
        auteur_address_lat.text = auteurAdrLat
        auteur_address_lng.text = auteurAdrLng
        //TextView Info Company
        auteur_company_name.text = auteurCpnName
        auteur_company_catchPhrase.text = auteurCpnCatchPhrase
        auteur_company_bs.text = auteurCpnBs

    }
}