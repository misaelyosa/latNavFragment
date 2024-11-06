package paba.b.latihannavigationfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [f2.newInstance] factory method to
 * create an instance of this fragment.
 */
class f2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_f2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val _tvFragment2 = view.findViewById<TextView>(R.id.tvFragment2)

        // Retrieve value from arguments and decrease by 2
        val currentValue = arguments?.getInt("value") ?: 97
        _tvFragment2.text = currentValue.toString()

        // Button to navigate to Fragment 3 with updated value
        view.findViewById<Button>(R.id.btnFragment3).setOnClickListener {
            val fragment3 = f3().apply {
                arguments = Bundle().apply {
                    putInt("value", currentValue - 3) // Decrease by 3 for Fragment 3
                }
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.frameContainer, fragment3)
                .addToBackStack(null)
                .commit()
        }
//        if (arguments!=null){
//            val currentValue = arguments?.getInt("value")
//            _tvFragment2.text = currentValue.toString()
//        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment f2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            f2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}