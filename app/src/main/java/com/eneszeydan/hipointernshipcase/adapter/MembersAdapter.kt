package com.eneszeydan.hipointernshipcase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eneszeydan.hipointernshipcase.databinding.RowDesignBinding
import com.eneszeydan.hipointernshipcase.models.Members

class MembersAdapter(
    var context: Context,
    var membersList: List<Members>
) : RecyclerView.Adapter<MembersAdapter.MembersViewHolder>() {

    inner class MembersViewHolder(var binding: RowDesignBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MembersViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val design = RowDesignBinding.inflate(layoutInflater, parent, false)
        return MembersViewHolder(design)
    }

    override fun onBindViewHolder(holder: MembersViewHolder, position: Int) {
        val member = membersList[position]

        holder.binding.memberName.text = member.name
    }

    override fun getItemCount(): Int {
        return membersList.size
    }
}