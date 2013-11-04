package com.appspot.Accent.model.service;

import java.util.Date;
import java.util.List;

import com.appspot.Accent.model.StageBegeleider;


public interface StageBegeleiderOfyDAO {
	   public List<StageBegeleider> getAllBegeleiders();
	   public StageBegeleider getBegeleider(String username);
	   public void updateBegeleider(StageBegeleider lu);
	   public void deleteBegeleider(StageBegeleider lu);
	   public void createBegeleider(String us, String pw, String em);
	}


