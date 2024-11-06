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
 * Use the [f1.newInstance] factory method to
 * create an instance of this fragment.
 */
class f1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    interface OnDataPassListener {
        fun onDataPass(data: String)
    }

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
        return inflater.inflate(R.layout.fragment_f1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val _tvFragment1 = view.findViewById<TextView>(R.id.tvFragment1)

        // Retrieve value from arguments
        val currentValue = arguments?.getInt("value") ?: 99
        _tvFragment1.text = currentValue.toString()

        // Button to navigate to Fragment 2 with updated value
        view.findViewById<Button>(R.id.btnFragment2).setOnClickListener {
            val fragment2 = f2().apply {
                arguments = Bundle().apply {
                    putInt("value", currentValue - 2) // Decrease by 2 for Fragment 2
                }
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.frameContainer, fragment2)
                .addToBackStack(null)
                .commit()
        }
        
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment f1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            f1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}