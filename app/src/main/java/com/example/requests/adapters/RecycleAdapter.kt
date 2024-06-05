package com.example.requests.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.requests.CurrentCounter
import com.example.requests.R
import com.example.requests.models.CounterName

class RecycleAdapter(private val counters: List<CounterName>,
    private val context: Context
): RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val counterName: TextView = itemView.findViewById(R.id.counterName)
        val timeZone: TextView = itemView.findViewById(R.id.timeZone)
        val moreBtn: Button = itemView.findViewById(R.id.moreBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.element, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return counters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.counterName.text = counters[position].counterName
        holder.timeZone.text = counters[position].counterInfo.timezone
        holder.moreBtn.setOnClickListener{
            val intent = Intent(context, CurrentCounter::class.java)

            intent.putExtra("uuid", counters[position].counterInfo.id)
            context.startActivity(intent)
        }
    }
}