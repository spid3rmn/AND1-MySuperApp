package com.example.mykampustest.ui.faq;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.mykampustest.databinding.FragmentFaqBinding;
import java.util.ArrayList;

public class FaqFragment extends Fragment {
        private FragmentFaqBinding binding;
        RecyclerView itemList;
        ItemAdapter itemAdapter;

        public View onCreateView(@NonNull LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState) {

            binding = FragmentFaqBinding.inflate(inflater, container, false);
            View root = binding.getRoot();

            itemList = binding.rvFaq;
            itemList.hasFixedSize();
            itemList.setLayoutManager(new LinearLayoutManager(this.getContext()));

            ArrayList<Faq> faqs = populateFaq();

            itemAdapter = new ItemAdapter(faqs);
            itemList.setAdapter(itemAdapter);

            return root;
        }

        private ArrayList<Faq> populateFaq(){
            ArrayList<Faq> faqs = new ArrayList<>();

            faqs.add(new Faq("When is the rent due to?",
                    "Last Day for paying the rent is on the 4th in every month " +
                            "– for late payments there will be a fee of 100 Dkk."));
            faqs.add(new Faq("How can I cancel my contract?",
                    "You will have to call the office of send an email to " +
                            "+45 35100068 contact@kamtjatka.dk "));
            faqs.add(new Faq("When can I cancel my contract?",
                    "Your contract is binding for 6 month, if you have a contract " +
                            "for more than one semester you need to cancel " +
                            "it 3 mount before the semester end."));
            faqs.add(new Faq("When do I need to extend my contract? ",
                    "You can extend your contract up to 2 weeks before semester start, " +
                            "but be aware that people can book your " +
                            "room 3 month from semester start. "));
            faqs.add(new Faq("Why do I need 2 copies of my Danish contract?",
                    "One is for the office, the other one is for you to use if you " +
                            "need Danish social security number, and the " +
                            "yellowcard."));
            faqs.add(new Faq("Can I pay the laundry card with credit card?",
                    "The laundry card you can only buy with Danish cash (50Dkk) " +
                            "and the same with the refill of the card can only" +
                            "be paid with Danish cash. One wash or dry will cost 10Dkk."));
            faqs.add(new Faq("Where can I get sent packages to? ",
                    "Your address will be on the first page in your contract, if you are not home, " +
                            "they will bring it to the nearest post office. " +
                            "Sometimes they will deliver the packages at the office, " +
                            "in case of that we will write you an email. " +
                            "Packages over 20kg will most likely be delivered at the office. " +
                            "The closest post office is at Løvbjerg grocery store, located 300m from Kamtjatka."));
            faqs.add(new Faq("Why can’t I pay online? ",
                    "The reason can be that your creditcard is not setup up to do online payment, so you need to contact your " +
                            "own bank."));
            faqs.add(new Faq("What do I do if I have an issue with the internet?",
                    "Restart your computer if that doesn’t do it, you have to contact itsupport@kamtjatka.dk remember to put in " +
                            "your name, room number and the issue. "));

            return faqs;
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            binding = null;
        }
}